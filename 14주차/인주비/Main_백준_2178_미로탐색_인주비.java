package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2178_미로탐색_인주비 {
	/*
	 * 92ms
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] maze = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}

		Queue<int[]> q = new LinkedList<int[]>();

		q.offer(new int[] { 0, 0, 1 });
		visited[0][0] = true;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int result = Integer.MAX_VALUE;
		while (q.size() > 0) {
			int[] current = q.poll();
			int r = current[0];
			int c = current[1];
			
			if (r == N-1 && c == M-1) {
				result = Math.min(result, current[2]);
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && maze[nr][nc] == 1) {
					q.offer(new int[] {nr, nc, current[2]+1});
					visited[nr][nc] = true;
				}
			}
		} // end of bfs
		
		System.out.println(result);
	}
}
