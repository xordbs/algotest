package week9;

import java.util.Scanner;

public class Main_BOJ_11726_2xn타일링_116ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[1001];
		
		// 점화식 : dp[n] = dp[n - 1] + dp[n - 2] (n >= 3)
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		
		System.out.println(dp[n]);
		
		sc.close();
	}
}
