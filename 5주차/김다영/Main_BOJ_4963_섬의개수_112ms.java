package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_4963_섬의개수_112ms {
	static int w; // 너비 
	static int h; // 높이 
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void dfs(int x, int y) {
		check[x][y] = true; // 방문으로 상태 변경 
		
		for(int i = 0; i < 8; i++) { // 방향 옮겨가며 확인 
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < h && ny >= 0 && ny < w) {
				if(map[nx][ny] == 1 && !check[nx][ny]) { // 위치가 땅이고, 방문하지 않았을때 
					dfs(nx, ny); // 재귀 
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			check = new boolean[h][w];
			
			for(int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[i].length; j++) {
					if(map[i][j] == 1 & !check[i][j]) { // 땅이고, 방문하지 않았을때  
						dfs(i, j); 
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
