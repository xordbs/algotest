package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {	// 시간초과
	static int[][] sub;
	static int[] arr;
	static int N;
	static int n;
	static int cnt=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int N1 = N+1;
		n=N-1;
		arr = new int[N+1];
		sub = new int[n][2];
		arr[1]=1;
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st =new StringTokenizer(br.readLine()," ");
			sub[i][0] = Integer.parseInt(st.nextToken());
			sub[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			if(sub[i][0]==1) {
				arr[sub[i][1]] = 1;
				tree(sub[i][1],cnt++);
				
			}else if(sub[i][1]==1) {
				arr[sub[i][0]] = 1;
				tree(sub[i][0],cnt++);
			}
		}
		
		for (int i = 2; i < N1; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	public static void tree(int num,int count) {
		if(count==n) {
			return;
		}
		for(int i=0; i<n; i++) {
			if(sub[i][0]==num && arr[sub[i][1]]==0) {
				arr[sub[i][1]] = num;
				tree(sub[i][1],cnt++);
			}else if(sub[i][1]==num && arr[sub[i][0]] == 0) {
				arr[sub[i][0]] = num;
				tree(sub[i][0],cnt++);
			}
		}
		return;
	}
}
