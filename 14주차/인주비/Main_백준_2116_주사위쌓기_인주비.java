package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2116_주사위쌓기_인주비 {
	/*
	 * 220ms
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] dice = new int[N][6];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// (A,F) (C,E) (B,D) = (0,5) (2,4) (1,3)
		// 첫 주사위는 6번 가능
		int sum = 0, max = Integer.MIN_VALUE;
		int top = 0, bottom = 0;
		int maxSum = 0;
		
		for (int i = 0; i < 6; i++) {
			sum = 0;
			max = Integer.MIN_VALUE;
			top = i;
			bottom = getBottom(top);

			// 나머지가 사이드
			for (int k = 0; k < 6; k++) {
				if (k != top && k != bottom) {
					max = Math.max(max, dice[0][k]);
				}
			}
			sum += max;

			for (int j = 1; j < N; j++) {
				max = Integer.MIN_VALUE;
				bottom = dice[j-1][top]; // 이제부터 윗면과 밑면은 정해져 있음
				
				for (int p = 0; p < 6; p++) {
					if (dice[j][p] == bottom) {
						bottom = p;
						top = getBottom(p);
						break;
					}
				}

				for (int k = 0; k < 6; k++) {
					if (k != top && k != bottom) {
						max = Math.max(max, dice[j][k]);
					}
				}
				sum += max;
			}
			maxSum = Math.max(sum, maxSum);
		}
		System.out.println(maxSum);
	}

	// 반대편 리턴
	public static int getBottom(int top) {
		if (top == 0)
			return 5;
		else if (top == 1)
			return 3;
		else if (top == 2)
			return 4;
		else if (top == 3)
			return 1;
		else if (top == 4)
			return 2;
		else
			return 0;
	}
}
