package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2178_미로탐색 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		char[][] map = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		String st = null;
		for (int i = 0; i < N; i++) {
			st = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = st.charAt(j);
			}
		}
		Queue<int[]> q = new LinkedList<>();
		int cnt=  0;
		q.add(new int[] {0,0});
		visited[0][0] = true;
		int[] dr = new int[] {-1,1,0,0}; // 상하좌우
		int[] dc = new int[] {0,0,-1,1};
		while(!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = arr[0]+ dr[d];
					int nc = arr[1]+ dc[d];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == '0' || visited[nr][nc]) {
						continue;
					}
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
					if(nr == N-1 && nc == M-1) {
						System.out.println(cnt+1);
					}
				}
			}
			
		}
	}
}