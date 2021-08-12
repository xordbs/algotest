package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14889_스타트와링크 {
	static int N;
	static int[][] input;
	static boolean[] isSelected;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][N];
		isSelected = new boolean[N];
		isSelected[0] = true;
		min = Integer.MAX_VALUE;
		
		// 한 팀에 N/2명씩 넣었을 때 능력치 합의 최소
		// 입력의 값이 크지 않으므로 다 구해보자 -> 조합으로 생각해 보면 N/2명씩 뽑고 안 뽑힌 사람들끼리 자동으로 다른 팀

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pick(0, 1);
		System.out.println(min);
	}// end of main

	// 123을 뽑는 경우와 456을 뽑는 경우는 같다. 135를 뽑는 경우와 246을 뽑는 경우는 같다.. 이걸 줄일 수 있는 방법은?
	// 어쨌든 첫번째 선수가 뽑히냐 안뽑히냐로 경우의 수가 절반이 나눠진다 -> N-1 중에서 2를 뽑는 경우..!
	public static void pick(int cnt, int start) {

		if (cnt == (N / 2 - 1)) {
			int startTeam = 0; // true는 startTeam, false는 linkTeam이라고 가정. 반대가 되어도 상관없음 어차피 차이를 구하는 것이기 때문에
			int linkTeam = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) { // i번째 선수가 start팀이라면
					for (int j = 0; j < N; j++) {
						if (isSelected[j]) // 또 다른 start팀을 찾아 떠난다
							startTeam += input[i][j];
					}
				} else { // i번째 선수가 link 팀이라면
					for (int j = 0; j < N; j++) {
						if (!isSelected[j]) // link 팀을 찾아 떠난다
							linkTeam += input[i][j];
					}
				}
			}

			min = Math.min(min, Math.abs(startTeam - linkTeam));
			return;
		}

		for (int i = start; i <= N - 1; i++) {
			isSelected[i] = true;
			pick(cnt + 1, i + 1);
			isSelected[i] = false;
		}
	}
}// end of class
