package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_10844_쉬운계단수_인주비 {
	/*
	 * 80ms
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// n == 2일 때부터 마지막 자리수가 0과 9일 때는 하나밖에 추가가 안되고, 나머지 1~8까지는 상관없이 2가지씩 더 추가될 수 있다.
		// n== 1일때 dp[1][0] = 0, dp[1][1~9] = 1
		// n == 2일 때 dp[2][0] = 0, dp[2][1~8] = 2, dp[2][9] = 1

		int[][] dp = new int[n + 1][10];

		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		// 끝자리가 9인 경우에는 직전자리가 8이었다는 뜻이고 0이라는 건 직전자리가 1인 경우밖에 안됨
		for (int i = 2; i <= n; i++) {
			dp[i][9] = dp[i - 1][8];
			dp[i][0] = dp[i - 1][1];
			for (int j = 1; j < 9; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
			}
		}

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + dp[n][i]) % 1000000000;
		}

		System.out.println(sum);
	}
}
