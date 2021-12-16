package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_15685_드래곤커브_인주비 {
	/*
	 * 92ms
	 */
	static int map[][];
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[102][102];
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] info = new int[N][4]; // 0: c, 1: r, 2: 방향, 3: 세대

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			drawLine(info[i]);
		}

		int result = sumSquare();
		System.out.println(result);
	}

	private static void drawLine(int[] info) {
		int c = info[0];
		int r = info[1];
		int dir = info[2];
		int gen = info[3];

		// 방향 저장. 90도 돌때마다 이전의 방향 다음걸로 넘어감
		// ex) 이전이 01 이었다면 다음은 21, 0121 이었다면 2321
		ArrayList<Integer> dirs = new ArrayList<>();
		dirs.add(dir);
		// 0세대
		map[r][c] = 1;
		map[r + dr[dir]][c + dc[dir]] = 1;
		r = r + dr[dir];
		c = c + dc[dir];

		// 세대 수 동안 그려야 함
		for (int i = 1; i <= gen; i++) {
			for (int d = dirs.size() - 1; d >= 0; d--) {
				int nd = (dirs.get(d) + 1) % 4; // +1한 걸로 넘어가는데 4가 넘어가면, 만약 3라면 0이 되어야 하니까
				// 입력으로 주어지는건 인덱스 안 벗어난다고 했으니까 굳이 인덱스 체크해줄 필요 없음
				r = r + dr[nd];
				c = c + dc[nd];

				map[r][c] = 1;
				dirs.add(nd);
			}
		}

	}

	private static int sumSquare() {
		int cnt = 0;
		for (int i = 0; i <= 101; i++) {
			for (int j = 0; j <= 101; j++) {
				if (map[i][j] == 0)
					continue;
				if (isSquare(i, j))
					cnt++;
			}
		}
		return cnt;
	}

	private static boolean isSquare(int i, int j) {
		if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1)
			return true;
		else
			return false;
	}
}
