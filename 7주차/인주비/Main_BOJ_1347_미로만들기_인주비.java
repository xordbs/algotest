package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_1347_미로만들기_인주비 {
	/*
	 * 76ms
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char[] input = new char[N];

		String s = br.readLine();
		for (int i = 0; i < N; i++) {
			input[i] = s.charAt(i);
		}

		// 미리 미로의 크기를 알 수 없으니 미로 크기의 변수값을 가지고 다녀야 한다
		// 50번이 이동의 최대이므로 49, 49에서 시작해서 미로 채우기
		char[][] maze = new char[102][102];
		for (int i = 0; i < 102; i++) {
			Arrays.fill(maze[i], '#');
		}

		// 하 좌 상 우
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, -1, 0, 1 };

		// 시작
		maze[49][49] = '.';
		int x = 49, y = 49;
		int min_r = 49, min_c = 49, max_r = 49, max_c = 49;
		int dir = 0;
		for (int i = 0; i < N; i++) {
			if (input[i] == 'F') {
				x += dr[dir];
				y += dc[dir];
//				if (maze[x][y] == '#') {
//					if (dir == 0) {
//						max_r++;
//					} else if (dir == 1) {
//						min_c--;
//					} else if (dir == 2) {
//						min_r--;
//					} else if (dir == 3) {
//						max_c++;
//					}
//				}
				maze[x][y] = '.';
				min_r = Math.min(min_r, x);
				max_r = Math.max(max_r, x);
				min_c = Math.min(min_c, y);
				max_c = Math.max(max_c, y);
			} else if (input[i] == 'R') {
				dir = dir == 3 ? 0 : dir + 1;
			} else { // L
				dir = dir == 0 ? 3 : dir - 1;
			}
		}

		for (int i = min_r; i <= max_r; i++) {
			for (int j = min_c; j <= max_c; j++) {
				sb.append(maze[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
