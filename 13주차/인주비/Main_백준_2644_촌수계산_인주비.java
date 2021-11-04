package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2644_촌수계산_인주비 {
	/*
	 * 76ms
	 */
	static int n, m;
	static boolean graph[][], visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new boolean[n + 1][n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x][y] = true;
		}

		Queue<int[]> q = new LinkedList<int[]>();
		visited = new boolean[n + 1];
		int cnt = 0;
		boolean flag = false;
		q.offer(new int[] { a, cnt });

		while (q.size() > 0) {
			int[] current = q.poll();
			int c = current[0];
			visited[c] = true;
			cnt = current[1];

			if (c == b) {
				flag = true;
				break;
			}

			for (int j = 1; j <= n; j++) {
				if (graph[c][j] && !visited[j]) {
					q.offer(new int[] { j, current[1] + 1 });
				}
			}

			for (int i = 1; i <= n; i++) {
				if (graph[i][c] && !visited[i]) {
					q.offer(new int[] { i, current[1] + 1 });
				}
			}
		}

		if (flag)
			System.out.println(cnt);
		else
			System.out.println(-1);
	}
}
