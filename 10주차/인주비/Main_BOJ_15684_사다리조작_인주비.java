package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_15684_사다리조작_인주비 {
	/*
	 * 1104ms
	 */
	static int N, M, H, ladder[][], min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		ladder = new int[H + 1][N + 1];

		for (int i = 0; i < M; i++) { // 가로선 입력받기
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			ladder[r][c] = 1;
			ladder[r][c + 1] = 2; // 1을 만나면 오른쪽으로 2를 만나면 왼쪽으로
		}

		min = Integer.MAX_VALUE;
		for (int i = 0; i <= 3; i++) {
			dfs(1, 1, 0, i);
			if (min != Integer.MAX_VALUE)
				break;
		}
		System.out.println(min != Integer.MAX_VALUE ? min : -1);
	}

	private static void dfs(int r, int c, int drawCnt, int totalCnt) { // 현재까지 그린 횟수, 총 그릴 수 있는 횟수
		// i가 i로 가는지 확인해서 되면 끝
		if (drawCnt == totalCnt) {
			if (check()) {
				min = totalCnt;
				return;
			}
			return;
		}

		for (int i = r; i <= H; i++) {
			for (int j = c; j < N; j++) {
				if (ladder[i][j] == 1 || ladder[i][j] == 2 || ladder[i][j+1] == 1)
					continue;
				ladder[i][j] = 1;
				ladder[i][j + 1] = 2;
				dfs(r, c + 2, drawCnt + 1, totalCnt);
				ladder[i][j] = 0;
				ladder[i][j + 1] = 0;
			}
			c = 1;
		}
	}

	// 사다리를 내리는 과정 r = 1부터 H까지
	// 1을 만나면 c++, 2를만나면 c--
	// 하나라도 i가 i로 오는게 아니라면 안됨
	private static boolean check() {
		for (int i = 1; i <= N; i++) {
			int current = i;
			for (int r = 1; r <= H; r++) {
				if (ladder[r][current] == 1) {
					current = current + 1;
				} else if (ladder[r][current] == 2) {
					current = current - 1;
				}
			}

			if (current != i) {
				return false;
			}
		}
		return true;
	}
}
