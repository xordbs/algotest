package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_2667_단지번호붙이기_인주비 {
	/*
	 * 100ms
	 */
	static int N, map[][], num[], sum;
	static boolean visited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		num = new int[625];

		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					sum = 0;
					dfs(i, j);
					num[cnt++] = sum;
				}
			}
		}
		System.out.println(cnt);
		Arrays.sort(num, 0, cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.println(num[i]);
		}
	}

	private static void dfs(int i, int j) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		visited[i][j] = true;
		sum++;
		for (int p = 0; p < 4; p++) {
			int nr = i + dr[p];
			int nc = j + dc[p];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}

	}
}
