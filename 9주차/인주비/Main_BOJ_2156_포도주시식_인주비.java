package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2156_포도주시식_인주비 {
	/*
	 * 104ms
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N + 1];
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		int result = 0;
		
		if (N >= 1) {
			dp[1] = input[1];
			result = dp[1];
		}
		if (N >= 2) {
			dp[2] = input[1] + input[2];
			result = Math.max(result, dp[2]);
		}
		if (N >= 3) {
			// => i를 기준으로 i를 마시기로 결정한 상태라면
			// i-1을 마셨는지 안마셨는지에 따라 달라진다
			// 1.i-1을 마신 상태라면 i-2는 무조건 못 마신 상태기 때문에 dp[i-3] + input[i-1]
			// 하지만 i-1을 마신 상태여도 두칸을 뛰어넘을 수도 있으므로 dp[i-4] + input[i-1]도 가능
			// 2. i-1을 마시지 않은 상태라면 dp[i-2]

			dp[3] = Math.max(input[2] + input[3], input[1] + input[3]);
			result = Math.max(result, dp[3]);
		}


		for (int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + input[i - 1] + input[i], dp[i - 2] + input[i]);
			dp[i] = Math.max(dp[i], dp[i - 4] + input[i - 1] + input[i]);
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
