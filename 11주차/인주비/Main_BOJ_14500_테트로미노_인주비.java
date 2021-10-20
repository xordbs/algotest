package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_14500_테트로미노_인주비 {
	static int N, M, input[][], temp[], result;
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = Integer.MIN_VALUE;
		temp = new int[4];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited = new boolean[N][M];
				temp[0] = input[i][j];
				visited[i][j] = true;
				pick(1, i, j);
			}
		}
		System.out.println(result);
	} // end of main

	private static void pick(int cnt,int r, int c) {
		if (cnt == 4) {
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				sum += temp[i];
			}
			result = Math.max(sum, result);
			return;
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
				temp[cnt] = input[nr][nc];
				pick(cnt+1, nr, nc);
			}
		}
		visited[r][c] = false;
		temp[cnt] = 0;
	}

}
