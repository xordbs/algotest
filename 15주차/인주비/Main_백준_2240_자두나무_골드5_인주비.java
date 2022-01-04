import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2240_자두나무_골드5_인주비 {
	/*
	 * 76ms
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] num = new int[T + 1];
		for (int i = 1; i <= T; i++) {
			num[i] = Integer.parseInt(br.readLine()) - 1; // 현재 위치와 자두나무 번호 비교하기 쉬우라고
		}

		int[][] dp = new int[W + 1][T + 1];

		for (int i = 1; i <= T; i++) {
			if (num[i] == 0)
				dp[0][i] = dp[0][i - 1] + 1;
		}

		for (int i = 1; i <= W; i++) {
			for (int j = 1; j <= T; j++) {
				if (i % 2 == num[j]) // 현재 위치가 자두가 떨어지는 나무라면 
					dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1); // 움직이지 않고 +1, 움직여서 +1 중 최대값 구하기
				else // 자두 떨어지지 않는다면
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1]); // 움직이지 않거나 움직이거나 둘 중 하나 최대값 구하기
			}
		}

		int answer = 0;
		
		// 움직이지 않고 최대일 수 있으므로 모든 움직임에 대해 최대값을 구해 본다
		for (int i = 0; i <= W; i++) {
			answer = Math.max(dp[i][T], answer);
		}
		
		System.out.println(answer);
	}
}
