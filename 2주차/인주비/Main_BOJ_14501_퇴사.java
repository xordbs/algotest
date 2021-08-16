package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_14501_퇴사 {
	static int N;
	static int[] t;
	static int[] p;
	static boolean[] isSelected;
	static int sum;
	static int max;

	public static void main(String[] args) throws Exception {
		// N일 동안 최대한 많은 수익을 낼 수 있는 방법을 찾는다
		// 입력이 15개까지므로 모든 경우의 수를 본다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		t = new int[N];
		p = new int[N];
		isSelected = new boolean[N];
		sum = 0;
		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		pick(0);
		System.out.println(max);
	}

	// 그 상담을 선택하느냐 하지 않느냐 -> 부분집합
	// 예외 조건은 앞에 선택한 날짜와 겹쳐버리면 선택하고 싶어도 못함. 최대한 적게 선택하는 방법
	public static void pick(int i) {
		if (i >= N) { // 끝 날짜에 다다른 경우 (마지막 날은 하고 싶어도 못함)
			sum();
			return;
		}

		if (i + t[i] > N) { // 상담할 수 있는 날짜를 넘어선 경우 현재 날짜 상담은 무조건 불가능함
			isSelected[i] = false;
			pick(i+1);
		} else { // 아직 범위 안에 있는 경우는 현재 날짜의 상담을 할지 말지 둘 다 생각해 줘야 함
			isSelected[i] = true;
			pick(i + t[i]);
			isSelected[i] = false;
			pick(i+1);
		}
	
	}

	public static void sum() {
		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				sum += p[i];
		}

		max = Math.max(max, sum);
		sum = 0;
		return;
	}
}// end of class
