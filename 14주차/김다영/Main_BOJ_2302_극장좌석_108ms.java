package week14;

import java.util.Scanner;

public class Main_BOJ_2302_극장좌석_108ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] dp = new int[41];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		// 점화식 : dp[i] = dp[i - 1] + dp[i - 2]
		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		int result = 1; // 앉을 수 있는 방법 가짓수 
		int cur = 0; // 현재 위치
		
		for(int i = 0; i < M; i++) {
			int vip = sc.nextInt(); // vip 자리(고정석) 
			result *= dp[vip - cur - 1]; 
			cur = vip;
		}
		result *= dp[N - cur]; // 마지막 vip자리부터 끝자리까지 
		
		System.out.println(result);
	}
}
