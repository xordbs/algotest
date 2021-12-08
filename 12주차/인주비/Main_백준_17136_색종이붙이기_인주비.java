package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17136_색종이붙이기_인주비 {
	/*
	 * 276ms
	 */
	static boolean visited[][];
	static int input[][], paper[], min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		input = new int[10][10];

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[10][10];
		paper = new int[6];
		min = Integer.MAX_VALUE;
		dfs(0, 0, 0);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	public static void dfs(int r, int c, int cnt) {
		if (r == 9 && c == 10) {
			// result = sum();
//			System.out.println(Arrays.toString(paper));
			min = Math.min(cnt, min);
			return;
		}

		if (cnt >= min) {
			return;
		}

		if (c > 9) {
			dfs(r + 1, 0, cnt);
			return;
		}

		if (input[r][c] == 1 && !visited[r][c]) {
			for (int k = 5; k >= 1; k--) {
//				System.out.println("solve start (" + r + ", " + c + ") " + k);
				if (check(r, c, k) && paper[k] < 5) {
					paper[k]++;
					attach(r, c, k, true);
//					System.out.println("(" + r + ", " + c + ") " + k + ": " + paper[k]);
					dfs(r, c + 1, cnt + 1);
					attach(r, c, k, false);
					paper[k]--;
				}
			}
		} else {
			dfs(r, c + 1, cnt);
		}

	}

	public static boolean check(int r, int c, int k) {
		for (int i = r; i < r + k; i++) {
			for (int j = c; j < c + k; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10)
					return false;
				if (input[i][j] == 0 || visited[i][j])
					return false;
				// attach(r, c, k, true);
			}
		}
		return true;
	}

	public static void attach(int r, int c, int k, boolean flag) {
		for (int i = r; i < r + k; i++) {
			for (int j = c; j < c + k; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10)
					continue;
				visited[i][j] = flag;
			}
		}
	}

//	public static int sum() {
//		int sum = 0;
//		for (int i = 1; i <= 5; i++) {
//			sum += paper[i];
//		}
//		return sum;
//	}

}
