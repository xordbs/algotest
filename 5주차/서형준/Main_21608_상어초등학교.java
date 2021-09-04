package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21608_상어초등학교 {	// 예제, 반례까지 다 찾아서 했는데 틀렸습니다.
	static int[][] arr;
	static int[][] sub;
	static int[] seq;
	static int N;
	static int N2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];	// 교실 자리 배열
		N2 = N * N;				// 학생수
		sub = new int[N2 + 1][5];	// 좋아하는 학생 조사배열	
		seq = new int[N2];		// 입력된 학생 순서배열
		int total = 0;		// 답

		for (int i = 0; i < N2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			seq[i] = n;	// 학생입력
			for (int j = 1; j <= 4; j++) {
				sub[n][j] = Integer.parseInt(st.nextToken());	// 좋아하는 학생 입력
			}
		}

		for (int i = 0; i < N2; i++) {
			find(seq[i]);	// 학생순서대로 자리 앉히기 시작
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int like = 0;	// 좋아하는 학생수
				if ((i - 1) >= 0) {
					for (int k = 1; k <= 4; k++) {
						if (sub[arr[i][j]][k] == arr[i - 1][j]) {
							like++;
							break;
						}
					}
				}
				if ((j - 1) >= 0) {
					for (int k = 1; k <= 4; k++) {
						if (sub[arr[i][j]][k] == arr[i][j - 1]) {
							like++;
							break;
						}
					}

				}
				if ((j + 1) < N) {
					for (int k = 1; k <= 4; k++) {
						if (sub[arr[i][j]][k] == arr[i][j + 1]) {
							like++;
							break;
						}
					}
				}
				if ((i + 1) < N) {
					for (int k = 1; k <= 4; k++) {
						if (sub[arr[i][j]][k] == arr[i + 1][j]) {
							like++;
							break;
						}
					}
				}
				switch (like) {	// 좋아하는 학생수에 따라 total 증가
				case 0:
					break;

				case 1:
					total += 1;
					break;
				case 2:
					total += 10;
					break;
				case 3:
					total += 100;
					break;
				case 4:
					total += 1000;
					break;
				}
			}
		}
		System.out.print(total);

	}

	static void find(int n) {	// n학생이 들어옴
		int r = 0;	//  n학생자리
		int c = 0;	// n학생 자리
		int mlike = 0;	// n 학생이 좋아하는 학생 최대숫자
		int mnon = 0;	// n 학생 주변 최대 빈자리
		for (int i = 0; i < N; i++) {	// 자리 탐색
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					int like = 0;	// 현재자리 좋아하는 학생수
					int non = 0;	// 현재자리 주변 빈자리
					if ((i - 1) >= 0) {	// 상
						if (arr[i - 1][j] == 0)	// 빈자리면
							non++;
						else {	// 빈자리 아니면
							for (int k = 1; k <= 4; k++) {	// 그자리 학생 내가 좋아하는학생인지 확인
								if (sub[n][k] == arr[i - 1][j]) {
									like++;
									break;	// 좋아하는학생 맞으니 빠르게 넘어감
								}
							}
						}
					}
					if ((j - 1) >= 0) {	// 좌
						if (arr[i][j - 1] == 0)
							non++;
						else {
							for (int k = 1; k <= 4; k++) {
								if (sub[n][k] == arr[i][j - 1]) {
									like++;
									break;
								}
							}
						}
					}
					if ((j + 1) < N) {	// 우
						if (arr[i][j + 1] == 0)
							non++;
						else {
							for (int k = 1; k <= 4; k++) {
								if (sub[n][k] == arr[i][j + 1]) {
									like++;
									break;
								}
							}
						}
					}
					if ((i + 1) < N) { // 하
						if (arr[i + 1][j] == 0)
							non++;
						else {
							for (int k = 1; k <= 4; k++) {
								if (sub[n][k] == arr[i + 1][j]) {
									like++;
									break;
								}
							}
						}
					}
					if (mlike < like) {	// 현재자리 주변에 좋아하는학생 가장 많은경우
						r = i;
						c = j;
						mlike = like;
						mnon = non;
					} else if (mlike == like && mnon < non) {	// 좋아하는학생 많은경우와 같고 + 빈자리도 많은경우
						r = i;
						c = j;
						mlike = like;
						mnon = non;
					} else if (mlike == 0 && mnon < non) {	// 좋아하는 학생은 없고 빈자리만 많은경우
						r = i;
						c = j;
						mnon = non;
					} else if(n == seq[N2-1]) {		// 마지막 남은자리인 경우
						r = i;
						c = j;
					}
				}
			}
		}
		arr[r][c] = n;
	}

}
