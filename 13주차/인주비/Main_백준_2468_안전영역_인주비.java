package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2468_안전영역_인주비 {
	/*
	 * 232ms
	 */
	static int n, map[][], temp[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		visited = new boolean[n][n];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(map[i][j], max);
			}
		}

		int cnt, result = Integer.MIN_VALUE;

		for (int rain = 0; rain <= max; rain++) {
			copy(map);
			visited = new boolean[n][n];
			cnt = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (temp[i][j] <= rain)
						temp[i][j] = 0;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (temp[i][j] != 0 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;

		for (int p = 0; p < 4; p++) {
			int nr = i + dr[p];
			int nc = j + dc[p];

			if (nr >= 0 && nr < n && nc >= 0 && nc < n && temp[nr][nc] != 0 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}

	private static void copy(int[][] map) {
		temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, map[0].length);
		}
	}
}
