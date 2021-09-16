package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2636_치즈 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int cnt = 0;
		int time = 0;
		int map[][] = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if(map[i][j] == 1) cnt++;
			}
		}
		
		int[] dr = {-1,1, 0,0}; // 상하좌우
		int[] dc = { 0,0,-1,1}; // 상하좌우
		Queue<int[]> q = new LinkedList<>();
		while(true) {
			q.offer(new int[] {0,0});
			visited = new boolean[N][M];
			int ch = 0;
			while(!q.isEmpty()) {
				int arr[] = q.poll();
				
				for (int k = 0; k < 4; k++) {
					int nr = arr[0] + dr[k]; 
					int nc = arr[1] + dc[k];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
					visited[nr][nc] = true;
					if(map[nr][nc] == 0) q.add(new int[] {nr,nc});
					else {
						ch++;
						map[nr][nc] = 0;
					}
				}
			}

			time++;
			cnt -= ch;
			if(cnt <= 0) {
				System.out.println(time);
				System.out.println(ch);
				break;
			}
		}
		
	}
}