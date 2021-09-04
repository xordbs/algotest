package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BOJ_21608_상어초등학교_인주비 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] classRoom = new int[N + 1][N + 1];
		LinkedList<LinkedList<Integer>> list = new LinkedList<>();

		for (int i = 1; i <= N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int stu = Integer.parseInt(st.nextToken());
			LinkedList<Integer> num = new LinkedList<>();
			num.add(stu);
			for (int j = 0; j < 4; j++) {
				num.add(Integer.parseInt(st.nextToken()));
			}
			list.add(num);
		}

		// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸
		// 2. 1번이 여러개면 인접한 칸 중에서 비어있는 칸이 가장 많은 칸
		// 3. 2번이 여러 개면 행의 번호, 열의 번호가 가장 작은 칸

		// 인접한 칸은 총 4개
		int maxBlank = 0, maxFav = 0;
		int blankCnt = 0, favCnt = 0;
		int x = 0, y = 0; // 앉은 자리
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int li = 0; li < list.size(); li++) {
			LinkedList<Integer> currentList = list.get(li);
			int current = currentList.get(0);
			x = 0;
			y = 0;
			maxFav = 0;
			maxBlank = 0;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					blankCnt = 0;
					favCnt = 0;

					if (classRoom[i][j] == 0) { // 빈자리이면
						for (int p = 0; p < dr.length; p++) { // 그 자리를 쓸 수 있는지 체크
							int nr = i + dr[p];
							int nc = j + dc[p];

							if (nr >= 1 && nr <= N && nc >= 1 && nc <= N) {
								if (classRoom[nr][nc] == 0) // 인접한 자리도 빈자리면
									blankCnt++;
								else { // 누가 앉아있으면
									for (int c = 1; c < currentList.size(); c++) { // 나랑 친한 친구인지 체크
										if (classRoom[nr][nc] == currentList.get(c))
											favCnt++;
									}
								}
							}
						} // 현재 위치: i,j 인접한 위치 다 체크 함
						if (favCnt > maxFav) { // (i,j)의 favCnt가 maxFav보다 크면 (1번조건)
							x = i; // 위치 기억해주기
							y = j;
							maxFav = favCnt;
							maxBlank = blankCnt;
						} else if (favCnt == maxFav && blankCnt > maxBlank) { // 2번조건
							x = i;
							y = j;
							maxBlank = blankCnt;
						}
					}
				}
			} // 자리 탐색 끝
			classRoom[x][y] = current;
		} // 학생 자리 정하기 끝

		// 만족도 구하기
		int like = 0, sat = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				int current = classRoom[i][j];
				like = 0;
				LinkedList<Integer> currentList = null;
				for (int c = 0; c < list.size(); c++) {
					if (list.get(c).get(0) == current)
						currentList = list.get(c);
				}
				if (currentList == null) continue;

				for (int p = 0; p < dr.length; p++) {
					int nr = i + dr[p];
					int nc = j + dc[p];

					if (nr >= 1 && nr <= N && nc >= 1 && nc <= N) {
						for (int c = 1; c < currentList.size(); c++) { // 나랑 친한 친구인지 체크
							if (classRoom[nr][nc] == currentList.get(c))
								like++;
						}
					}
				}
				
				if (like == 1)
					sat += 1;
				else if (like == 2)
					sat += 10;
				else if (like == 3)
					sat += 100;
				else if (like == 4)
					sat += 1000;
			}
		}
		System.out.println(sat);
	}
}
