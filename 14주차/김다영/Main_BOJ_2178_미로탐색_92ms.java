package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2178_미로탐색_92ms {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0}; // 동 서 남 북
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		visited[0][0] = true;
		
		bfs(0, 0);
		
		System.out.println(map[N - 1][M - 1]);
	}
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) { // 큐에 있는 좌표 탐색 끝날때까지 반복
			int[] cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				// 범위 out, 벽, 이미 탐색한 좌표 -> pass
				if(nx < 0 || nx >= N || ny < 0 || ny >= M  || map[nx][ny] == 0 || visited[nx][ny]) continue;
				
				queue.add(new int[] {nx, ny}); // 다음 탐색 좌표 add
				
				visited[nx][ny] = true; // 다음 좌표 방문 ok
				
				map[nx][ny] = map[cur[0]][cur[1]] + 1; // 다음 좌표 = 현재 좌표 + 1
			}
		}
		
	}
}
