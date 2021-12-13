package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17070_파이프옮기기_인주비 {
	/*
	 * bfs 시간초과
	 * dfs 696ms
	 * move(재귀) 184ms
	 */
	
	static int N, map[][];
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = 0;
		// bfs();
		// dfs(0, 1, 0);
		move(0, 1, 0);
		System.out.println(answer);
	}

	private static void move(int r, int c, int k) {
		if (r == N - 1 && c == N - 1 && map[r][c] != 1) {
			answer++;
			return;
		}

		if (k == 0) {
			if (isIn(r, c + 1) && map[r][c + 1] == 0)
				move(r, c + 1, 0);
			if (isIn(r + 1, c + 1) && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0)
				move(r + 1, c + 1, 2);
		} else if (k == 1) {
			if (isIn(r + 1, c) && map[r + 1][c] == 0)
				move(r + 1, c, 1);
			if (isIn(r + 1, c + 1) && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0)
				move(r + 1, c + 1, 2);
		} else if (k == 2) {
			if (isIn(r, c + 1) && map[r][c + 1] == 0)
				move(r, c + 1, 0);
			if (isIn(r + 1, c) && map[r + 1][c] == 0)
				move(r + 1, c, 1);
			if (isIn(r + 1, c + 1) && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0)
				move(r + 1, c + 1, 2);
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	private static void dfs(int r, int c, int k) {
		// System.out.println("(" + r + ", " + c + ") - " + k);
		if (r == N - 1 && c == N - 1) {
			answer++;
			return;
		}
		int[][] dr = { { 0, 1 }, { 1, 1 }, { 0, 1, 1 } };
		int[][] dc = { { 1, 1 }, { 0, 1 }, { 1, 0, 1 } };

		int nextDir = 0;
		for (int i = 0; i < dr[k].length; i++) {
			int nr = r + dr[k][i];
			int nc = c + dc[k][i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1)
				continue;

			if (dr[k][i] == 0 && dc[k][i] == 1)
				nextDir = 0;
			else if (dr[k][i] == 1 && dc[k][i] == 0)
				nextDir = 1;
			else if (dr[k][i] == 1 && dc[k][i] == 1)
				nextDir = 2;

			if (nextDir == 2) {
				if (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1)
					continue;
			}
			dfs(nr, nc, nextDir);
		}
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		// 0: 가로, 1: 세로, 2: 대각선
		int[][] dr = { { 0, 1 }, { 1, 1 }, { 0, 1, 1 } };
		int[][] dc = { { 1, 1 }, { 0, 1 }, { 1, 0, 1 } };

		q.offer(new int[] { 0, 1, 0, 0 });
		visited[0][1] = true;

		int result = 0;
		while (q.size() > 0) {
			int[] c = q.poll();
			System.out.println("(" + c[0] + ", " + c[1] + ") - " + c[2]);
			if (c[0] == N - 1 && c[1] == N - 1) {
				result++;
				continue;
			}

			int nextDir = 0;
			for (int i = 0; i < dr[c[2]].length; i++) {
				int nr = c[0] + dr[c[2]][i];
				int nc = c[1] + dc[c[2]][i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1)
					continue;

				if (dr[c[2]][i] == 0 && dc[c[2]][i] == 1)
					nextDir = 0;
				else if (dr[c[2]][i] == 1 && dc[c[2]][i] == 0)
					nextDir = 1;
				else if (dr[c[2]][i] == 1 && dc[c[2]][i] == 1)
					nextDir = 2;

				if (nextDir == 2) {
					if (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1)
						continue;
				}
				q.offer(new int[] { nr, nc, nextDir });
			}
		}
		System.out.println(result);
	}
}
