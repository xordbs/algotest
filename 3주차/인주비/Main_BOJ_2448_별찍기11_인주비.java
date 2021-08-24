package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2448_별찍기11_인주비 {
	/**
	 * 
	 552ms
	 */

	static int N;
	static char[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		arr = new char[N][N * 2 - 1];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = ' ';
			}
		}
		
		print(0, 0, N);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void print(int r, int c, int cnt) {
		if (cnt == 3) {
			arr[r][c + 2] = '*';
			arr[r + 1][c + 1] = '*';
			arr[r + 1][c + 3] = '*';
			for (int i = c; i < c+5; i++)
				arr[r+2][i] = '*';
			return;
		}

		print(r, c + cnt/2, cnt / 2);
		print(r + cnt/2, c, cnt / 2);
		print(r + cnt/2, c+cnt, cnt / 2);
	}
}
