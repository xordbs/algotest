package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_15686_치킨배달_인주비 {
	/*
	 * 168ms
	 */
	static int N, M, min;
	static int[][] map, chicken, answer;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		chicken = new int[13][2]; // 최대 13개

		int c = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0, index = 0; j < N; j++, index += 2) {
				map[i][j] = str.charAt(index) - '0';
				if (map[i][j] == 2) {
					chicken[c][0] = i;
					chicken[c][1] = j;
					c++;
				}
			}
		}

		visited = new boolean[c];
		answer = new int[M][2];
		min = Integer.MAX_VALUE;
		// 치킨집 중 M개를 뽑고
		// 그에 해당하는 최소값을 갱신...?
		pick(0, 0);
		System.out.println(min);
	} // end of main

	private static void pick(int start, int cnt) {
		if (cnt == M) {
			int temp = 0, dis = 0, sum = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp = Integer.MAX_VALUE;
					if (map[i][j] == 1) {
						for (int k = 0; k < answer.length; k++) {
							dis = Math.abs(answer[k][0] - i) + Math.abs(answer[k][1] - j);
							temp = Math.min(temp, dis);
						}
						sum += temp;
					}
				}
			}
			min = Math.min(sum, min);
			return;
		}

		for (int i = start; i < visited.length; i++) {
			if (visited[i])
				continue;
			answer[cnt][0] = chicken[i][0];
			answer[cnt][1] = chicken[i][1];
			visited[i] = true;
			pick(i, cnt + 1);
			visited[i] = false;
		}
	}

} // end of class
