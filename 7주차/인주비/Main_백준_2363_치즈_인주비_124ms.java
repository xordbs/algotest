package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2363_치즈_인주비 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[][] cheese = new int[r][c];
		int cheeseCnt = 0;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if (cheese[i][j] == 1)
					cheeseCnt++;
			}
		}

		int hour = 0;
		int lastCheese = 0;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (cheeseCnt > 0) { // 겉면 하나씩 탐색
			Queue<int[]> queue = new LinkedList<int[]>();
			boolean[][] visited = new boolean[r][c];
			queue.add(new int[] { 0, 0 });
			visited[0][0] = true;
			hour++;
			lastCheese = cheeseCnt;
			while (queue.size() > 0) {
				int[] current = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nr = current[0] + dr[i];
					int nc = current[1] + dc[i];

					if (nr >= 0 && nr < r && nc >= 0 && nc < c && !visited[nr][nc]) {
						visited[nr][nc] = true;
						if (cheese[nr][nc] == 1) {
							cheese[nr][nc] = 0;
							cheeseCnt--;
						} else
							queue.offer(new int[] { nr, nc });
					}
				}
			}
		}

		System.out.println(hour);
		System.out.println(lastCheese);
	}
}
