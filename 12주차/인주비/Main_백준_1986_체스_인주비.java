package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1986_체스_인주비 {
	/*
	 * 132ms
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] chess = new int[N][M];

		st = new StringTokenizer(br.readLine(), " ");
		int qn = Integer.parseInt(st.nextToken());
		int[][] queen = new int[qn][2];
		for (int i = 0; i < qn; i++) {
			queen[i][0] = Integer.parseInt(st.nextToken()) - 1;
			queen[i][1] = Integer.parseInt(st.nextToken()) - 1;
			chess[queen[i][0]][queen[i][1]] = 1;
		}

		st = new StringTokenizer(br.readLine(), " ");
		int kn = Integer.parseInt(st.nextToken());
		int[][] knight = new int[kn][2];
		for (int i = 0; i < kn; i++) {
			knight[i][0] = Integer.parseInt(st.nextToken()) - 1;
			knight[i][1] = Integer.parseInt(st.nextToken()) - 1;
			chess[knight[i][0]][knight[i][1]] = 2;
		}

		st = new StringTokenizer(br.readLine(), " ");
		int pn = Integer.parseInt(st.nextToken());
		int[][] pawn = new int[pn][2];
		for (int i = 0; i < pn; i++) {
			pawn[i][0] = Integer.parseInt(st.nextToken()) - 1;
			pawn[i][1] = Integer.parseInt(st.nextToken()) - 1;
			chess[pawn[i][0]][pawn[i][1]] = 3;
		}

		// 1. queen 이동
		int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

		for (int i = 0; i < qn; i++) {
			int r = queen[i][0];
			int c = queen[i][1];

			for (int k = 0; k < 8; k++) {
				int index = 0;
				while (true) {
					int nr = r + dr[k] * index;
					int nc = c + dc[k] * index;

					// 장애물 못 뛰어넘음
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || chess[nr][nc] == 2 || chess[nr][nc] == 3)
						break;

					chess[nr][nc] = -1;

					index++;
				}
			}
		} // end of queen

		// 2. knight 이동
		int[] dr2 = { -2, -1, -2, -1, 2, 1, 2, 1 };
		int[] dc2 = { -1, -2, 1, 2, -1, -2, 1, 2 };

		for (int i = 0; i < kn; i++) {
			int r = knight[i][0];
			int c = knight[i][1];

			for (int k = 0; k < 8; k++) {
				int nr = r + dr2[k];
				int nc = c + dc2[k];

				// 장애물 뛰어넘을 수 있음
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (chess[nr][nc] == 0)
					chess[nr][nc] = -1;
			}
		} // end of knight

		// 안전한 칸 세기
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (chess[i][j] == 0)
					sum++;
			}
		}

		System.out.println(sum);
	}
}
