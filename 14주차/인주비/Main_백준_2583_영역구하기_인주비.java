package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_백준_2583_영역구하기_인주비 {
	/*
	 * 80ms
	 */
	static boolean[][] visited;
	static int[][] map;
	static int M, N, K, sum;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}
		
		visited = new boolean[M][N];
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0 ; j <N; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					sum = 0;
					dfs(i, j);
					result.add(sum);
				}
			}
		}
		
		Collections.sort(result);
		
		System.out.println(result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;
		sum++;
		
		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			
			if (nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 0) {
				dfs(nr, nc);
			}
		}
	}
}
