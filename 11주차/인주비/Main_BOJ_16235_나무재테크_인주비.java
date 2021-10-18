package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BOJ_16235_나무재테크_인주비 {
	static int N, M, K, map[][], A[][]; // 겨울이 다 지나야 양분을 추가함
	static ArrayList[][] trees;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		A = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = 5;
			}
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		trees = new ArrayList[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				trees[i][j] = new ArrayList<Integer>();
			}
		}
		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			trees[x][y].add(age);
		}

		for (int i = 0; i < K; i++) {
			simulate();
		}

		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				result += trees[i][j].size();
			}
		}
		System.out.println(result);
	}

	private static void simulate() {

		// 봄
//		ArrayList[][] deadTrees = new ArrayList[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 어린 나무부터
				Collections.sort(trees[i][j]);

				ArrayList<Integer> current = trees[i][j];
				int fuel = 0;

				ArrayList<Integer> temp = new ArrayList<>();

				for (int c = 0; c < current.size(); c++) {
					int age = current.get(c);
					if (map[i][j] - age >= 0) {
						map[i][j] -= age;
						temp.add(age + 1);
					} else { // 죽음
						// 여름
						// 죽은 나무가 양분으로 추가된다
						fuel = age / 2;
					}
				}

				// 현재 좌표 비워준다음에 다시 삽입
				trees[i][j] = new ArrayList<>();

				for (int a : temp)
					trees[i][j].add(a);

				map[i][j] += fuel;

			}
		}

		// 가을
		// 나이가 5의 배수여야 함. 8개 칸에 나이가 1인 나무가 생김
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ArrayList<Integer> current = trees[i][j];

				for (int c = 0; c < current.size(); c++) {
					int age = current.get(c);
					if (age % 5 == 0) {
						for (int p = 0; p < 8; p++) {
							int nr = i + dr[p];
							int nc = j + dc[p];
							if (nr >= 1 && nr <= N && nc >= 1 && nc <= N) {
								trees[nr][nc].add(1);
							}
						}
					}
				}
			}
		} // 가을 끝

		// 겨울
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] += A[i][j];
			}
		}
	}
}
