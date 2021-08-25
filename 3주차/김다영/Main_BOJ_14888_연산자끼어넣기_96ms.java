package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14888_연산자끼어넣기_96ms {
	static int N;
	static int[] num;
	static int[] op;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 수의 개수 (2 ≤ N ≤ 11)
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		op = new int[4]; // 연산자 개수 담을 배열 
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, num[0]);
		
		System.out.println(max);
		System.out.println(min);
	} // end of main
	
	public static void dfs(int idx, int ans) {
		if(idx == N) {
			min = Math.min(min, ans);
			max = Math.max(max, ans);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(op[i] > 0) { // 연산자가 1개 이상있으면 
				op[i]--; // 해당 연산자 -1 
				
				if(i == 0) {
					dfs(idx + 1, ans + num[idx]);
				} else if(i == 1) {
					dfs(idx + 1, ans - num[idx]);
				} else if(i == 2) {
					dfs(idx + 1, ans * num[idx]);
				} else {
					dfs(idx + 1, ans / num[idx]);
				}
				op[i]++; // 재귀 끝나면 다시 연산자 개수 +1 
			}
		}
	}
} // end of class
