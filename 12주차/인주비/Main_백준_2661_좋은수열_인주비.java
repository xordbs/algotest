package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2661_좋은수열_인주비 {
	/*
	 * 100ms
	 */
	static int N, num[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		pick("");
		//pick2(0);
	}

	private static void pick(String str) {

		as: for (int i = 1; i <= 3; i++) {
			// 배열로 잘라서 생각하지 말고 그냥 문자열로
			for (int c = 1; c <= str.length() / 2; c++) {
				String front = str.substring(str.length() - c - c, str.length() - c);
				String end = str.substring(str.length() - c);
				if (front.equals(end))
					continue as;
			}
			if (str.length() == N) {
				System.out.print(str);
				System.exit(0);
			}
			pick(str + i);
		}
	}

	private static void pick2(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(num[i]);
			}
			System.exit(0);
		}

		for (int i = 1; i <= 3; i++) {
			if (cnt >= 1 && num[cnt - 1] == i)
				continue;
			if (cnt >= 3 && num[cnt - 3] == num[cnt - 1] && num[cnt - 2] == i)
				continue;
			if (cnt >= 5 && num[cnt - 5] == num[cnt - 2] && num[cnt - 4] == num[cnt - 1] && num[cnt - 3] == i)
				continue;
			if (cnt >= 7 && num[cnt - 7] == num[cnt - 3] && num[cnt - 6] == num[cnt - 2] && num[cnt - 5] == num[cnt - 1]
					&& num[cnt - 4] == i)
				continue;

			num[cnt] = i;
			pick2(cnt + 1);
		}
	}
}
