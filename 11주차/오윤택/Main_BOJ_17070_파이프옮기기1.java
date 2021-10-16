package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_17070_파이프옮기기1 {
	static int N;
	static int[][] map;
	static int[] dr = { 0, 1, 1 }; // 우,하,우하 
	static int[] dc = { 1, 0, 1 };
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0); //시작은 (0,0), (0,1) 그 끝지점이 (0,1) 이므로 dfs 시작을 0, 1 로  

		System.out.println(result);
	}

	public static void dfs(int x, int y, int d) {
		if (x == N-1 && y == N-1) {
			result++;
		}

		for (int i = 0; i < 3; i++) { 
			
			// 가로로되있을때 세로는 불가능 세로일때 가로는 불가능 이므로 continue
			if (d == 0 && i == 1) continue;
			if (d == 1 && i == 0) continue;
			// 대각선일때 빈칸이 아닌경우 체크
			if (i == 2) { 
				if (y + 1 < N && x + 1 < N) {
					if (map[x][y + 1] != 0 || map[x + 1][y] != 0) continue;
				}
			}

			int nr = x + dr[i];
			int nc = y + dc[i];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if (map[nr][nc] != 1) dfs(nr, nc, i);
			}
		}
	}
}