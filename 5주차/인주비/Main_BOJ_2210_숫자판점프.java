package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BOJ_2210_숫자판점프 {
	/*
	 * 132ms
	 */

	static String[][] input;
	static HashSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		input = new String[5][5];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				input[i][j] = st.nextToken();
			}
		}

		set = new HashSet<String>();

		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				dfs(i, j, "");

		System.out.println(set.size());
	}

	public static void dfs(int i, int j, String res) {
		if (res.length() == 6) {
			set.add(res);
			return;
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int p = 0; p < 4; p++) {
			int nr = i + dr[p];
			int nc = j + dc[p];

			if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5)
				dfs(nr, nc, res + input[nr][nc]);
		}
	}
}
