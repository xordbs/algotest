import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	/*
	 * 84ms
	 */

	static int N;
	static int[] arr;
	static char[] op;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int testCase = 0; testCase < TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			op = new char[N - 1];
			for (int i = 0; i < N; i++) {
				arr[i] = i + 1;
			}
			pick(0, 1);
			sb.append("\n");
		}
		System.out.println(sb);
	} // end of main

	public static void pick(int cnt, int res) {
		if (cnt == N - 1) {
			if (res == 0) {
				for (int i = 0; i < N - 1; i++) {
					sb.append(arr[i]).append(op[i]);
					// System.out.print(arr[i]);
					// System.out.print(op[i]);
				}
				sb.append(arr[N - 1]).append("\n");
				// System.out.println(arr[N - 1]);
			}
			return;
		}

		// +, -, 공백 중에 하나를 뽑아야 한다
		// 1부터 시작해서 첫번째 기호를 뽑을 때 cnt+1과 res 결과를 가지고 연산해 줌

		op[cnt] = ' ';
		if (cnt > 0 && op[cnt - 1] == '+') {
			pick(cnt + 1, res - arr[cnt] + (arr[cnt] * 10 + arr[cnt + 1]));
		} else if (cnt > 0 && op[cnt - 1] == '-') {
			pick(cnt + 1, res + arr[cnt] - (arr[cnt] * 10 + arr[cnt + 1]));
		} else {
			pick(cnt + 1, res * 10 + arr[cnt + 1]);
		}

		op[cnt] = '+';
		pick(cnt + 1, res + arr[cnt + 1]);

		op[cnt] = '-';
		pick(cnt + 1, res - arr[cnt + 1]);
	}
} // end of class
