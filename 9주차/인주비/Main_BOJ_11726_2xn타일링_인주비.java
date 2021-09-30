package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_11726_2xn타일링_인주비 {
	/*
	 * 96ms
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n + 2];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
		}

		System.out.println(dp[n]);
	}
}
