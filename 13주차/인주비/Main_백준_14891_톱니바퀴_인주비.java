package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14891_톱니바퀴_인주비 {
	/*
	 * 80ms
	 */
	static int[][] gears;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		gears = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				gears[i][j] = str.charAt(j) - '0';
			}
		}

		int cnt = Integer.parseInt(br.readLine());
		int[][] rotation = new int[cnt][2];
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			rotation[i][0] = Integer.parseInt(st.nextToken()) - 1; // 톱니바퀴 번호
			rotation[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < cnt; i++) {
			solve(rotation[i][0], rotation[i][1]);
		}

		int score = 0;
		for (int i = 0; i < 4; i++) {
			if (gears[i][0] == 1) {
				score += Math.pow(2, (double) i);
			}
		}
		System.out.println(score);
	}

	public static void solve(int gear, int dir) {
		// 0번째 바퀴는 오른쪽에만 바퀴가 있으므로 2번 톱니 확인
		// 1, 2번째 바퀴는 양쪽에 다 있으므로 6번 2번 톱니 확인
		// 3번째 바퀴는 왼쪽에만 있으므로 6번 톱니 확인

		int[] d = new int[4]; // 회전해야 할 방향을 넣어두는 배열. 1은 시계 -1은 반시계
		d[gear] = dir;

		if (gear == 0) {

			if (canRotate(gear, 2, 1, 6)) {
				d[1] = -dir;
				if (canRotate(1, 2, 2, 6)) {
					d[2] = -d[1];
					if (canRotate(2, 2, 3, 6)) {
						d[3] = -d[2];
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				if (d[i] != 0)
					rotate(i, d[i]);
			}

		} else if (gear == 1) {
			int[] order = { 1, 0, 2, 3 }; // 회전을 해야 하는 순서. 1번 톱니바퀴부터 0, 2, 3번째 톱니바퀴 순으로 확인한다

			if (canRotate(gear, 6, gear - 1, 2)) {
				d[gear - 1] = -dir;
			}

			if (canRotate(gear, 2, gear + 1, 6)) {
				d[gear + 1] = -dir;
				if (canRotate(gear + 1, 2, gear + 2, 6)) {
					d[gear + 2] = -d[gear + 1];
				}
			}

			for (int i = 0; i < 4; i++) {
				if (d[order[i]] != 0)
					rotate(order[i], d[order[i]]);
			}

		} else if (gear == 2) {
			int[] order = { 2, 1, 3, 0 };

			if (canRotate(gear, 6, gear - 1, 2)) {
				d[gear - 1] = -dir;
				if (canRotate(gear - 1, 6, gear - 2, 2)) {
					d[gear - 2] = -d[gear - 1];
				}
			}

			if (canRotate(gear, 2, gear + 1, 6)) {
				d[gear+1] = -dir;
			}

			for (int i = 0; i < 4; i++) {
				if (d[order[i]] != 0)
					rotate(order[i], d[order[i]]);
			}

		} else if (gear == 3) {
			if (canRotate(gear, 6, gear - 1, 2)) {
				d[gear - 1] = -dir;
				if (canRotate(gear - 1, 6, gear - 2, 2)) {
					d[gear - 2] = dir;
					if (canRotate(gear - 2, 6, gear - 3, 2)) {
						d[gear - 3] = -dir;
					}
				}
			}

			for (int i = 3; i >= 0; i--) {
				if (d[i] != 0)
					rotate(i, d[i]);
			}
		}
	}

	private static void rotate(int gear, int dir) {
		//System.out.println(gear + " " + dir);

		if (dir == 1) { // 시계
			int temp = gears[gear][7];
			for (int i = 7; i >= 1; i--) {
				gears[gear][i] = gears[gear][i - 1];
			}
			gears[gear][0] = temp;
		} else { // 반시계
			int temp = gears[gear][0];
			for (int i = 0; i < 7; i++) {
				gears[gear][i] = gears[gear][i + 1];
			}
			gears[gear][7] = temp;
		}
	}

	public static boolean canRotate(int i1, int j1, int i2, int j2) {
		if (gears[i1][j1] != gears[i2][j2])
			return true;
		else
			return false;
	}
}
