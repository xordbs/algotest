package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1912_연속합_인주비 {
	/*
	 * 200ms
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int INF = -100000;
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		long[] dp = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			dp[i] = INF;
		}

		dp[0] = input[0];
		long result = input[0];
		
		//해당원소를 포함하냐 포함하지 않느냐 
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] + input[i], input[i]);
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
