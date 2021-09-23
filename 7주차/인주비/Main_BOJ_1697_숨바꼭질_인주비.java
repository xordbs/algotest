package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1697_숨바꼭질_인주비 {
	/*
	 * 120ms
	 */
	
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		visited = new boolean[100001];
		// 배열의 첫번째 원소: 위치, 두번째 원소: 너비 = 몇초뒤인지
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { N, 0 });
		visited[N] = true;
		int result = 0;

		while (q.size() > 0) {
			int[] current = q.poll();
			int point = current[0];
			int cnt = current[1];

			if (current[0] == K) {
				result = cnt;
				break;
			}

			if (point - 1 >= 0 && !visited[point - 1]) {
				visited[point - 1] = true;
				q.offer(new int[] { point - 1, cnt + 1 });
			}
			if (point + 1 <= 100000 && !visited[point + 1]) {
				visited[point + 1] = true;
				q.offer(new int[] { point + 1, cnt + 1 });
			}
			if (point * 2 <= 100000 && !visited[point * 2]) {
				visited[point * 2] = true;
				q.offer(new int[] { point * 2, cnt + 1 });
			}
		}
		System.out.println(result);
	}
}
