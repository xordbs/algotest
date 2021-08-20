package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10819_차이를최대로_인주비 {

	static int N;
	static int[] input;
	static int[] numbers;
	static boolean[] isSelected;
	static int sum, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		numbers = new int[N];
		isSelected = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		max = 0;
		solve(0);
		System.out.println(max);
	}
	
	// input 중에 N만큼의 순열을 뽑아서 차이를 하나씩 계산해 본다
	public static void solve(int cnt) {

		if (cnt == N) {
			sum = 0;
			for (int i = 0 ; i < N-1; i++) {
				sum += Math.abs(numbers[i] - numbers[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;
			solve(cnt+1);
			isSelected[i] = false;
		}

	}
}
