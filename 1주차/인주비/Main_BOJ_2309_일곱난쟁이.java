package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_2309_일곱난쟁이 {
	static int[] input;
	static int[] results;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		input = new int[9];
		results = new int[7];

		for (int i = 0; i < 9; i++)
			input[i] = Integer.parseInt(br.readLine());

		solve(0, 0);
	} // end of main

	private static void solve(int cnt, int start) {
		// 9명 중에 7명을 뽑는 조합
		StringBuilder sb = new StringBuilder();

		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++)
				sum += results[i];
			if (sum == 100) { // 합계가 100인 조합 출력
				Arrays.sort(results); // 오름차순 정렬
				for (int i = 0; i < 7; i++)
					sb.append(results[i]).append("\n");
			}
			System.out.print(sb);
			return;
		}

		for (int i = start; i < 9; i++) {
			results[cnt] = input[i];
			solve(cnt + 1, i + 1);
		}
	}
}// end of class
