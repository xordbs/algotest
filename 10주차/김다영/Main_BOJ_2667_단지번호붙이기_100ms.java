package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_BOJ_2667_단지번호붙이기_100ms {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
	static int[] dy = {0, 0, -1, 1};
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 지도의 크기
		map = new int[N][N];
		visited = new boolean[N][N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt = 1; // 단지 내 집의 수 
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		System.out.println(list.size()); // 총 단지 수 = list의 사이즈 
		
		Collections.sort(list); // 정렬 
        for(int i = 0; i < list.size(); i++) {
        	System.out.println(list.get(i)); 
        }
	}
	
	public static int dfs(int x, int y) {
        visited[x][y] = true; // 방문 체크 
        
        for(int i = 0; i < 4; i++) { 
        	int nx = x + dx[i];
        	int ny = y + dy[i];
        
        	if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
