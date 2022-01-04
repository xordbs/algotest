import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_����_2240_�ڵγ���_���5_���ֺ� {
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
			num[i] = Integer.parseInt(br.readLine()) - 1; // ���� ��ġ�� �ڵγ��� ��ȣ ���ϱ� ������
		}

		int[][] dp = new int[W + 1][T + 1];

		for (int i = 1; i <= T; i++) {
			if (num[i] == 0)
				dp[0][i] = dp[0][i - 1] + 1;
		}

		for (int i = 1; i <= W; i++) {
			for (int j = 1; j <= T; j++) {
				if (i % 2 == num[j]) // ���� ��ġ�� �ڵΰ� �������� ������� 
					dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1); // �������� �ʰ� +1, �������� +1 �� �ִ밪 ���ϱ�
				else // �ڵ� �������� �ʴ´ٸ�
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1]); // �������� �ʰų� �����̰ų� �� �� �ϳ� �ִ밪 ���ϱ�
			}
		}

		int answer = 0;
		
		// �������� �ʰ� �ִ��� �� �����Ƿ� ��� �����ӿ� ���� �ִ밪�� ���� ����
		for (int i = 0; i <= W; i++) {
			answer = Math.max(dp[i][T], answer);
		}
		
		System.out.println(answer);
	}
}
