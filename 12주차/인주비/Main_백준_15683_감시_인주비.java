package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15683_감시_인주비 {
	/*
	 * 340ms
	 */
	
	static int N, M, cctvs[][], index, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		cctvs = new int[8][2]; // cctv 위치 저장 배열. 최대 8개
		index = 0; // cctv 개수 기억해두는 인덱스

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					cctvs[index][0] = i;
					cctvs[index][1] = j;
					index++;
				}
			}
		}

		min = Integer.MAX_VALUE;
		pick(0, map);
		System.out.println(min);


	}

	private static void pick(int cnt, int[][] map) {
		if (cnt == index) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0)
						sum++;
				}
			}
			min = Math.min(min, sum);
			return;
		}

		int r = cctvs[cnt][0];
		int c = cctvs[cnt][1];
		int info = map[r][c];

		// 감시
		// 1,3,4번 씨씨티비는 가능한 방향의 개수가 4가지
		// 2번은 2가지
		// 5번은 1가지. 나머지 내용은 다 똑같음
		if (info == 1 || info == 3 || info == 4) {
			for (int k = 0; k < 4; k++) {
				int[][] temp = copy(map);
				cctvControl(true, info, k, r, c, temp);
				pick(cnt + 1, temp);
				// cctvControl(false, info, k, r, c);
				// map = temp;
			}
	
		} else if (info == 2) {
			for (int k = 0; k < 2; k++) {
				int[][] temp = copy(map);
				cctvControl(true, info, k, r, c, temp);
				pick(cnt + 1, temp);
			}
		} else if (info == 5) {
			int[][] temp = copy(map);
			cctvControl(true, info, 0, r, c, temp);
			pick(cnt + 1, temp);
		}
	}

	// true면 on, false면 off < 이부분은 원래 껐다 켰다 반복하려고 했는데 배열 복사로 해결했기 때문에 필요없어짐
	// 가능한 방향 다 
	private static void cctvControl(boolean flag, int info, int k, int r, int c, int[][] map) {
		if (info == 1) {
			if (k == 0)
				down(flag, r, c, map);
			else if (k == 1)
				up(flag, r, c, map);
			else if (k == 2)
				left(flag, r, c, map);
			else if (k == 3)
				right(flag, r, c, map);
		} else if (info == 2) {
			if (k == 0) {
				left(flag, r, c, map);
				right(flag, r, c, map);
			} else if (k == 1) {
				up(flag, r, c, map);
				down(flag, r, c, map);
			}
		} else if (info == 3) {
			if (k == 0) {
				up(flag, r, c, map);
				right(flag, r, c, map);
			} else if (k == 1) {
				right(flag, r, c, map);
				down(flag, r, c, map);
			} else if (k == 2) {
				down(flag, r, c, map);
				left(flag, r, c, map);
			} else if (k == 3) {
				left(flag, r, c, map);
				up(flag, r, c, map);
			}
		} else if (info == 4) {
			if (k == 0) {
				up(flag, r, c, map);
				right(flag, r, c, map);
				left(flag, r, c, map);
			} else if (k == 1) {
				up(flag, r, c, map);
				right(flag, r, c, map);
				down(flag, r, c, map);
			} else if (k == 2) {
				down(flag, r, c, map);
				left(flag, r, c, map);
				right(flag, r, c, map);
			} else if (k == 3) {
				left(flag, r, c, map);
				up(flag, r, c, map);
				down(flag, r, c, map);
			}
		} else if (info == 5) {
			up(flag, r, c, map);
			right(flag, r, c, map);
			down(flag, r, c, map);
			left(flag, r, c, map);
		}
	}
	
	// 방향만 달라지는 거라 dr dc 배열 만들어서 하면 하나로 합칠 수 있을 듯
	private static void up(boolean flag, int r, int c, int[][] map) {

		int index = 1;
		while (true) {
			int nr = r + -1 * index;

			if (nr < 0 || nr >= N || map[nr][c] == 6)
				break;

			if (flag && map[nr][c] == 0)
				map[nr][c] = -1;
			else if (!flag && map[nr][c] == -1)
				map[nr][c] = 0;

			index++;
		}
	}

	private static void down(boolean flag, int r, int c, int[][] map) {

		int index = 1;
		while (true) {
			int nr = r + 1 * index;

			if (nr < 0 || nr >= N || map[nr][c] == 6)
				break;

			if (flag && map[nr][c] == 0)
				map[nr][c] = -1;
			else if (!flag && map[nr][c] == -1)
				map[nr][c] = 0;
			index++;
		}
	}

	private static void left(boolean flag, int r, int c, int[][] map) {

		int index = 1;
		while (true) {
			int nc = c + -1 * index;

			if (nc < 0 || nc >= M || map[r][nc] == 6)
				break;

			if (flag && map[r][nc] == 0)
				map[r][nc] = -1;
			else if (!flag && map[r][nc] == -1)
				map[r][nc] = 0;

			index++;
		}
	}

	private static void right(boolean flag, int r, int c, int[][] map) {

		int index = 1;
		while (true) {
			int nc = c + 1 * index;

			if (nc < 0 || nc >= M || map[r][nc] == 6)
				break;

			if (flag && map[r][nc] == 0)
				map[r][nc] = -1;
			else if (!flag && map[r][nc] == -1)
				map[r][nc] = 0;

			index++;
		}
	}

	// 씨씨티비 끌때 겹치는 남의 감시 영역도 꺼지는 문제 발견
	// 내가 켰던 것만 끌수 있게 하는 방법 => 켰던 걸 기억해 두기
	private static int[][] copy(int[][] map) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, map[0].length);
		}
		return temp;
	}
}
