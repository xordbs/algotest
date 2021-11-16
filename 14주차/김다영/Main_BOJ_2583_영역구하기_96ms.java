package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BOJ_2583_영역구하기_96ms {
	static int M, N, K, cnt;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 직사각형 좌표 수
		
		map = new int[M][N];
		visited = new boolean[M][N];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			for(int x = x1; x < x2; x++) {
				for(int y = y1; y < y2; y++) {
					map[x][y] = 1;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0) { // 분리된 영역 -> dfs로 영역 넓이 구하기 
					cnt = 0;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		
		System.out.println(list.size()); // 분리된 영역 개수 
		Collections.sort(list); // 정렬 
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " "); 
		}	
	}
	
	public static void dfs(int x, int y) {
		int[] dx= {-1, 1, 0, 0};
		int[] dy= {0, 0, -1, 1};
		
		map[x][y] = 1; // 방문했으니까 1로 값 바꾸기
		cnt++; 
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue; // 범위 out 
			if(map[nx][ny] == 0) dfs(nx, ny); // 범위 내 분리된 영역일 때, dfs호출
		}
	}
}
