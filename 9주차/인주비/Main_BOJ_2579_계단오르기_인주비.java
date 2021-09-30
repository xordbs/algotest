package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2579_계단오르기_인주비 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/* 
		 * 92ms
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if (N == 1) {
			System.out.println(Integer.parseInt(br.readLine()));
			System.exit(0);
		}
		
		int[] stairs = new int[N+1]; // 시작점을 0이라고 생각
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		// n번째 계단의 최적해를 구하고 싶다.
		// n-1번째 계단을 밟은 상태라면 n번째 계단을 밟는데에는 무리가 없지만 만약 n-2번째 계단을 밟았다면 문제가 됨.
		// 따라서 1. n-1번째 계단을 밟았다면 n-2번째 값은 제외, n-3번째 계단까지의 최적해에 n-1번째 계단값과 n번째 계단값을 더해준다.
		// 2. n-1번째 계단을 밟지 않았다면 n-2번째 계단은 고려하지 않아도 되므로 n-2번째까지의 최적해에 n번째 계단값을 더한다.
		// 이 두개의 값의 최댓값을 구한다.
		dp[0] = 0;
		dp[1] = stairs[1];
		dp[2] = stairs[1] + stairs[2];

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i]);
		}
		
		System.out.println(dp[N]);
	}
}
