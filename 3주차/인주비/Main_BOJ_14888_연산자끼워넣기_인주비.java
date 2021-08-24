package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14888_연산자끼워넣기_인주비 {
	/**
	 * 124ms
	 */

	static int N;
	static int[] input;
	static int[] ops;
	static int max, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		ops = new int[4];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			ops[i] = Integer.parseInt(st.nextToken());
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		pick(0, input[0]);

		System.out.println(max);
		System.out.println(min);
	}

	// 선택자를 선택한다. 선택할 때마다 calculate 함수로 현재 cnt와 연산자 종류, 현재까지의 연산결과를 넘겨준다
	public static void pick(int cnt, int res) {
		if (cnt == N - 1) {
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (ops[i] > 0) {
				ops[i]--; // 하나 선택
				pick(cnt + 1, calculate(cnt, i, res));
				ops[i]++; // 다시 복구
			}
		}

	}

	public static int calculate(int cnt, int ops, int res) {
		switch (ops) {
		case 0:
			return res + input[cnt + 1];
		case 1:
			return res - input[cnt + 1];
		case 2:
			return res * input[cnt + 1];
		case 3:
			return res / input[cnt + 1];
		}
		return 0;
	}
}
