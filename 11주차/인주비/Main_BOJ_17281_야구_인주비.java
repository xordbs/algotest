package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_17281_야구_인주비 {
	/*
	 * 564ms
	 */
	
	static int N, input[][], hitter[], result;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		input = new int[N][10]; // 9번타자까지 입력
		hitter = new int[10];
		visited = new boolean[10];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 9; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 4번타자는 1번선수로 고정
		hitter[4] = 1;
		visited[1] = true;

		result = Integer.MIN_VALUE;

		pick(1);

		System.out.println(result);
	}

	private static void pick(int cnt) {
		if (cnt == 4) { // 4번타자 고정이라
			pick(cnt + 1);
			return;
		}

		if (cnt == 10) {
			play();
			return;
		}

		for (int i = 2; i <= 9; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			hitter[cnt] = i;
			pick(cnt + 1);
			visited[i] = false;
		}
	}

	// 현재 뽑힌 타순으로 게임을 해본다
	private static void play() {
		int index = 1; // 1번타자부터 시작
		int player, hit, outCnt = 0, score = 0;
		boolean[] base = new boolean[4]; // 루상의 주자 확인

		for (int i = 0; i < N; i++) {
			outCnt = 0;
			Arrays.fill(base, false);
			
			while (outCnt != 3) {
				if (index == 10) { // 타자일순일 경우에 해당
					index = 1;
				}
				player = hitter[index]; // 1번타자부터 시작
				hit = input[i][player]; // 현재 플레이어의 타석 결과
				if (hit == 1) {
					for (int b = 3; b >= 1; b--) {
						if (base[b]) {
							if (b == 3) { // 3루에 사람이 있으면
								score++; // 득점
								base[b] = false;
								continue;
							}
							base[b] = false;
							base[b + 1] = true; // 1루씩 진루
						}
					}
					base[1] = true;
				} else if (hit == 2) {
					for (int b = 3; b >= 1; b--) {
						if (base[b]) {
							if (b == 3 || b == 2) { // 3루 혹은 2루에 사람이 있으면
								score++; // 득점
								base[b] = false;
								continue;
							}
							base[b] = false;
							base[b + 2] = true; // 2루씩 진루
						}
					}
					base[2] = true;
				} else if (hit == 3) {
					for (int b = 3; b >= 1; b--) {
						if (base[b]) {
							score++; // 루상의 모든 주자 득점
							base[b] = false;
							continue;
						}
					}
					base[3] = true; // 타자는 3루로
				} else if (hit == 4) { // 홈런
					for (int b = 1; b <= 3; b++) {
						if (base[b]) { // 루상의 모든 주자 득점
							score++;
							base[b] = false;
						}
					}
					score++; // 홈런친 타자 점수까지
				} else if (hit == 0) {
					outCnt++;
				}
				index++;
			} // 아웃카운트 3개 될동안 도는 반복문

		}
		result = Math.max(score, result);
	} // end of play
}
