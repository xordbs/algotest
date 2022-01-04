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
				if (i % 2 == num[j])
					dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1]);
			}
		}

		int answer = 0;
		
		for (int i = 0; i <= W; i++) {
			answer = Math.max(dp[i][T], answer);
		}
		
		System.out.println(answer);
	}
}
