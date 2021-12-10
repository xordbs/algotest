package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17471_게리멘더링_인주비 {
	/*
	 * 80ms
	 */
	static int N, pop[], result, check;
	static boolean graph[][], group[], visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new boolean[N + 1][N + 1];
		pop = new int[N + 1]; // 인구수

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int link = Integer.parseInt(st.nextToken());
				graph[i][link] = true;
			}
		}
		group = new boolean[N + 1];
		result = Integer.MAX_VALUE;
		pick(1);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	// true false로 나누는 과정
	// 기저조건에서 연결됐는지 확인 후 연결됐으면 인구수 차이 구하기
	private static void pick(int cnt) {
		if (cnt == N + 1) {
			// true면 a팀 false면 b팀인 상황에서 다음은 연결되는지 확인하기
			// System.out.println(Arrays.toString(group));
			visited = new boolean[N + 1];
			boolean tCheck = false, fCheck = false;

			// isConnected 함수에 한번씩만 들어가야 연결된 거라서 flag 변수를 주었음
			for (int i = 1; i <= N; i++) {
				if (group[i] && !tCheck) {
					tCheck = true;
					isConnected(i, true);
				} else if (!group[i] && !fCheck) {
					fCheck = true;
					isConnected(i, false);
				}
			}

			if (tCheck && fCheck) {
				// 최소값 계산
				int s = 0;
				// 방문 안한 도시가 있으면 dfs를 안돈거라서 연결이 안되어있다는 뜻
				for (int i = 1; i <= N; i++) {
					if (visited[i])
						s++;
				}
				if (s == N) { // 연결이 되어있으면
					// System.out.println("가능");
					getDiff();
					// System.out.println(result);
				}
			}
			return;
		}
		group[cnt] = true;
		pick(cnt + 1);
		group[cnt] = false;
		pick(cnt + 1);

	}

	private static void getDiff() {
		int tSum = 0, fSum = 0;
		for (int i = 1; i <= N; i++) {
			if (group[i])
				tSum += pop[i];
			else
				fSum += pop[i];
		}
		result = Math.min(Math.abs(tSum - fSum), result);
	}

	private static void isConnected(int i, boolean flag) {
		if (flag) {
			// System.out.println("--- true --- ");
			if (group[i] && !visited[i]) {
				visited[i] = true;
				dfs(i, group[i]);
			}
		} else {
			// System.out.println("--- false --- ");
			if (!group[i] && !visited[i]) {
				visited[i] = true;
				dfs(i, group[i]);
			}
		}
	}

	private static void dfs(int i, boolean team) {
		// System.out.println(i);
		for (int p = 1; p <= N; p++) {
			if (group[p] == team && graph[i][p] && !visited[p]) {
				visited[p] = true;
				dfs(p, team);
			}
		}

	}
}
