import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_����_11052_ī�屸���ϱ�_�ǹ�1_���ֺ� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] price = new int[N + 1];
		int[] dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		dp[1] = price[1];

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++)
				dp[i] = Math.max(dp[i], dp[i-j] + price[j]);
		}
		System.out.println(dp[N]);
	}
}
