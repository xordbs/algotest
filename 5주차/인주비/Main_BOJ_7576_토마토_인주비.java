package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7576_토마토_인주비 {
	
	/*
	 * 600ms
	 */
	
	static int[][] tomato;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		tomato = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int day = 0;

		Queue<int[]> queue = new LinkedList<int[]>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 1) {
					queue.offer(new int[] { i, j, 0 });
				}
			}
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			day = current[2];
			for (int p = 0; p < 4; p++) {
				int nr = current[0] + dr[p];
				int nc = current[1] + dc[p];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (tomato[nr][nc] == 0) {
						queue.offer(new int[] { nr, nc, current[2] + 1 });
						tomato[nr][nc] = 1;
					}
				}
			}
		}
		boolean flag = true;

		as: for (int i = 0; i < N; i++) {
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
