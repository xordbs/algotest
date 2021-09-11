package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	static int ROW;
	static int COL;
	static int[][] arr;
	static int cnt;
	static int[] dr = {0,1,1,1,0,-1,-1,-1 };	// 9시부터 반시계방향으로 돌림
	static int[] dc = {-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			COL = Integer.parseInt(st.nextToken());	// 배열 열크기
			ROW = Integer.parseInt(st.nextToken());	// 배열 행크기
			if (ROW == 0 && COL == 0)
				break;

			arr = new int[ROW + 2][COL + 2];	// 조건문 처리하기 싫어서 한바퀴 더두름
			for (int i = 1; i <= ROW; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= COL; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			cnt = 0;
			for (int i = 1; i <= ROW; i++) {
				for (int j = 1; j <= COL; j++) {
					if (arr[i][j] == 1) {	// 배열 돌면서 1이면 카운트시작
						cnt++;
						find(i,j);
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}

	public static void find(int sr, int sc) {
		arr[sr][sc]=0;	// 해당 인덱스 0으로 바꿔줌 재탐색 안하게 
		for (int n = 0; n < 8; n++) {
			if(arr[sr+dr[n]][sc+dc[n]] == 1) {
				find(sr+dr[n],sc+dc[n]);	// 연결된 섬 돌기
			}
		}
	}
}
