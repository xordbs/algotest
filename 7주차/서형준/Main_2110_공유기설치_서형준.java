package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2110_공유기설치_서형준 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken())-2;
		int[] arr = new int[N];
		boolean[] check = new boolean[N];
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int min = N-1;
		check[0]=true;
		check[N-1] =true;
		int[] ch = new int[2];
		
		q.offer(new int[] {min/2,min/2});
		while(C>0) {
			
			ch = q.poll();
			if(check[ch[0]]) {
				if(!check[ch[0]-1]) {
					check[ch[0]-1] = true;
					min = ch[1]/2;
					if(ch[0]-1-min>0) q.offer(new int[] {ch[0]-1-min,min});
					if(ch[0]-1+min<N-1) q.offer(new int[] {ch[0]-1+min,min});
					
				}else if(!check[ch[0]+1]) {
					check[ch[0]+1] = true;
					min = ch[1]/2;
					if(ch[0]+1-min>0) q.offer(new int[] {ch[0]+1-min,min});
					if(ch[0]+1+min<N-1) q.offer(new int[] {ch[0]+1+min,min});
				}else C++;
			}else {
				check[ch[0]] = true;
				min = ch[1]/2;
				if(ch[0]-min>0) q.offer(new int[] {ch[0]-min,min});
				if(ch[0]+min<N-1) q.offer(new int[] {ch[0]+min,min});
			}
			C--;
		}
		int start = arr[0];
		int dis = Integer.MAX_VALUE;
		for (int i = 1; i < N; i++) {
			if(check[i]) {
				if(dis > arr[i]-start) dis = arr[i]-start;
				start = arr[i];
			}
		}
		System.out.print(dis);
		
	}

}
