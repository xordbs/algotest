package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2156_포도주시식_인주비 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N+1];
		int[] dp = new int[N+1];

		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = input[1];
		dp[2] = input[1] + input[2];

		// i번째 순서의 최대값은
		// i-1번째 포도주를 마신 상태에서 i-2번째 포도주도 마셨다면 i는 무조건 선택할 수가 없음
		// i-1번째 포도주를 마신 상태라면 i-3번째까지 최대에 i-1, i를 선택한 것이 최대
		// i-1번째를 마신 게 아니라면 i-2번째 최대에 i를 선택한 것이 최대
		
		int result = 0;
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + input[i - 1] + input[i], dp[i - 2] + input[i]);
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
