package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815_숫자카드 {
	static int[] arr;
	static int N;
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < M; i++) {
			find(Integer.parseInt(st.nextToken()));
		}
		System.out.print(sb);
	}
	
	public static void find(int n) {
		int i=N/2;
		int[] arr2 = new int[] {0,N-1};
		if(n<arr[0] || n > arr[N-1]) {
			sb.append(0).append(" ");
		}else if(n == arr[0] || n == arr[N-1]) {
			sb.append(1).append(" ");
		}else {
			while(true) {
				if(((i-1)>=0 && (i+1) < N) && (n==arr[i] || n==arr[i-1] || n==arr[i+1])) {
					sb.append(1).append(" ");
					break;
				}else if(n > arr[i] && n < arr[i+1]) {
					sb.append(0).append(" ");
					break;
				}else if(n < arr[i]) {
					arr2[1]=i;
					i=(i+arr2[0])/2;
				}else if(n > arr[i]) {
					arr2[0]=i;
					i=(i+arr2[1])/2;
				}
			}
		}
	}
}
