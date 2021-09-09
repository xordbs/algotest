package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_4963_섬의개수_116ms {

	static int[][] map;
	static boolean[][] chk;
	static int r,c;
	
	static int dr[] = {-1,-1,-1, 0, 1, 1,  1, 0}; // 좌상, 상, 우상, 우, 우하, 하, 좌하, 좌
	static int dc[] = {-1, 0, 1, 1, 1, 0, -1, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			c = Integer.parseInt(str.nextToken());
			r = Integer.parseInt(str.nextToken());
			if (r == 0 && c == 0) break;

			map = new int[r][c];
			chk = new boolean[r][c];
			int cnt = 0;
			
			for (int i = 0; i < r; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < c; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
				}
			}
			
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(map[i][j] == 1 && !chk[i][j]) { // 배열 위치의 값이 1이고 false면 dfs 실행 및 cnt 증가 
						dfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

	}

	private static void dfs(int i, int j) {
		
		chk[i][j] = true; // map의 값이 1이고 방문 했기에 방문 true로 변
		
		for (int k = 0; k < 8; k++) { // 대각선까지 총 8번 진
			int nr = i + dr[k];
			int nc = j + dc[k];
			
			if(nr < 0 || nc < 0 || nr >= r || nc >= c) {
				continue;
			}
			if(map[nr][nc] == 1 && !chk[nr][nc]) { // nr,nc의 map 값이 1이고 방문하지 않았으면 재
				dfs(nr,nc);
			}
		}
	}
}
