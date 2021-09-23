package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7569_토마토_인주비 {
	/*
	 * 704ms
	 */
	
	static int[][] tomato;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		tomato = new int[N * H][M];

		for (int i = 0; i < N * H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int day = 0;

		Queue<int[]> queue = new LinkedList<int[]>();

		for (int i = 0; i < N * H; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 1) {
					queue.offer(new int[] { i, j, 0 });
				}
			}
		}
		
		if (queue.size() == 0) {
			System.out.println(-1);
			System.exit(0);
		}

		// 위 아래 추가
		int[] dr = { -1, 1, 0, 0, -N, N };
		int[] dc = { 0, 0, -1, 1, 0, 0 };

		while (queue.size() > 0) {
			int[] current = queue.poll();
			day = current[2];
			int order = current[0] / N; // 몇번째 상자인지
			for (int p = 0; p < 6; p++) {
				int nr = current[0] + dr[p];
				int nc = current[1] + dc[p];
				if (p == 4 || p == 5) { // 위아래는 따로 인덱스 관리해줌
					if (nr >= 0 && nr < N * H && nc >= 0 && nc < M) {
						if (tomato[nr][nc] == 0) {
							queue.offer(new int[] { nr, nc, day + 1 });
							tomato[nr][nc] = 1;
						}
					}
				}
				if (nr >= order * N && nr < (order + 1) * N && nc >= 0 && nc < M) { // 박스 안에서 인덱스 관리해줌
					if (tomato[nr][nc] == 0) {
						queue.offer(new int[] { nr, nc, day + 1 });
						tomato[nr][nc] = 1;
					}
				}
			}
		}

		boolean flag = true;

		as: for (int i = 0; i < N * H; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					flag = false;
					break as;
				}
			}
		}

		if (flag)
			System.out.println(day);
		else
			System.out.println(-1);
	} // end of main
}
