package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1520_내리막길_인주비 {
	/*
	 * 실패 ^^;;
	 */
	static int M, N, map[][], dp[][], result;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		dp = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = 0;
		visited[0][0] = true;
		dp[0][0] = 1;
		dfs(0, 0);
//		System.out.println(dfs(0, 0));

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}


	private static void dfs(int r, int c) {
		if (r == M - 1 && c == N - 1) {
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < M && nc >= 0 && nc < N) {

				if (map[r][c] > map[nr][nc]) {
					if (!visited[nr][nc]) {
						visited[nr][nc] = true;
						dp[r][c] += 1;
						dfs(nr, nc);
						visited[nr][nc] = false;
					} else {
						dp[nr][nc] += dp[r][c];
					}
				}
			}
		}
	}

//	private static void dfs(int r, int c, boolean[][] visited) {
//		if (r == M - 1 && c == N - 1) {
//			cnt++;
//			return;
//		}
//
//		for (int i = 0; i < 4; i++) {
//			int nr = r + dr[i];
//			int nc = c + dc[i];
//
//			if (nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc]) {
//				if (map[r][c] > map[nr][nc]) {
//					visited[nr][nc] = true;
//					dfs(nr, nc, visited);
//					visited[nr][nc] = false;
//				}
//			}
//		}
//	}
}
