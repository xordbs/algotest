package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1915_가장큰정사각형_288ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[n+1][m+1];
		int dp[][] = new int[n+1][m+1];
		int max = 0; // 가장 긴 정사각형 한변 길이
		
		for(int i = 1; i <= n; i++) {
			String str = br.readLine();
			for(int j = 1; j <= m; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		// 현재 좌표가 1일 때,
		// 세 위치(왼쪽 위, 위, 왼쪽)의 dp 값 중 최솟값에 1을 더한 값이 정사각형의 한 변이 된다.
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j] == 1) {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max * max); // 가장 큰 정사각형 넓이
	}
}