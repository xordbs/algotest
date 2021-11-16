package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2302_극장좌석_인주비 {
	/*
	 * 76ms
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		int[] vip = new int[M];

		for (int i = 0; i < M; i++) {
			vip[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		// 안막혀있을때 dp[n] = dp[n-2] + dp[n-1];
		// 막힌곳을 기준으로 범위를 나눠서 그 좌석수에 해당하는 경우의 수를 곱한다

		// 안막혀있을수도 있어서 모든 경우를 구해줌
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int result = 1;

		if (M == 0) {
			System.out.println(dp[N]);
		} else {
			result *= dp[vip[0] - 1];

			for (int i = 1; i < M; i++) {
				result *= dp[vip[i] - vip[i - 1] - 1];
			}

			result *= dp[N - vip[M - 1]];

			System.out.println(result);
		}
	}
}
