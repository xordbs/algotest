package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2310_어드벤처게임_인주비 {
	/*
	 * 50%에서 계속 실패....
	 */
	static int N, m[], money;
	static boolean canVisit[][], visited[], flag;
	static char door[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;

			canVisit = new boolean[N + 1][N + 1]; // 방문할 수 있는 정보
			door = new char[N + 1]; // 어떤 방인지
			m = new int[N + 1]; // 얼마 지불해야 하는지

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				door[i] = st.nextToken().charAt(0);
				m[i] = Integer.parseInt(st.nextToken());

				while (true) {
					// canVisit[i][i] = true;
					int num = Integer.parseInt(st.nextToken());

					if (num == 0)
						break;

					canVisit[i][num] = true;
				}

			}
			visited = new boolean[N + 1];
			money = 0;
			go(1);

			if (flag)
				sb.append("Yes").append("\n");
			else
				sb.append("No").append("\n");
		}
		System.out.println(sb);
	}

	private static void go(int r) {

		if (door[r] == 'L') {
			if (money < m[r])
				money = m[r];
		} else if (door[r] == 'T') {
			if (money >= m[r]) {
				money -= m[r];
			} else
				return;
		}

		visited[r] = true;

		if (r == N) {
			flag = true;
			return;
		}

		boolean[] list = canVisit[r];

		for (int i = 1; i < list.length; i++) {
			if (list[i] && !visited[i]) {
				go(i);
			}
		}
	}
	
//	private static void go(int r) {
//		if (r == N) {
//			flag = true;
//			return;
//		}
//
//		boolean[] list = canVisit[r];
//
//		for (int i = 1; i < list.length; i++) {
//			if (list[i] && !visited[r]) {
//				if (door[i] == 'E') {
//					visited[r] = true;
//					go(i);
//				} else if (door[i] == 'L') {
//					if (money < m[i])
//						money = m[i];
//					visited[r] = true;
//					go(i);
//				} else if (door[i] == 'T') {
//					if (money >= m[i]) {
//						money -= m[i];
//						visited[r] = true;
//						go(i);
//					} else
//						return;
//				}
//				visited[r] = false;
//			}
//		}
//
//	}

}
