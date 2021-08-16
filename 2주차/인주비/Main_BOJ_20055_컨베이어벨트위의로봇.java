package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_20055_컨베이어벨트위의로봇 {
	static int N;
	static int K;
	static int[] belt;
	static boolean[] robot; // 로봇 위치를 체크하는 배열. true면 현재 칸에 로봇이 있다는 뜻.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 1. 벨트 회전
		// 2. 로봇이 이동할 수 있다면 (이동하려는 칸에 로봇이 없고, 내구도가 1 이상 남아있어야 함) 이동. 없다면 가만히
		// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 로봇을 올린다.
		// 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료. cnt 변수?

		// int[][] belt = new int[2][N];

		// 어차피 반으로 나눠서 생각하는 건데 그냥 한 줄이라고 생각하면?
		belt = new int[2 * N];
		robot = new boolean[N]; // 어차피 윗줄에만 있으니 N개만 생각하면 된다

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 2*N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		int cnt = 0; // 내구도가 0이 된 칸을 세어 줄 변수
		int temp = 0;
		boolean temp2 = false;// 회전할 때 쓸 임시변수
		
		while (cnt < K) { 
			// 1. 벨트 회전
			temp = belt[2 * N - 1];
			temp2 = robot[N - 1];

			off();
			for (int i = 2 * N - 1; i > 0; i--) {
				// 한칸씩 이동하는데 맨 끝에 있는 것만 0으로
				belt[i] = belt[i - 1];
			}
			for (int i = N-1; i > 0; i--) {
				robot[i] = robot[i - 1];
			}
			belt[0] = temp;
			robot[0] = temp2;

			off();
			// 2. 로봇 이동
			// 가장 먼저 올라간 로봇부터니까 역으로
			for (int i = N-2; i >= 0; i--) { // N-2까지만 체크할 수 있는 이유는 로봇 내리기를 시도했으니 무조건 false 일 것
				if (robot[i]) {
					if (!robot[i + 1] && belt[i + 1] >= 1) { // 다음칸에 로봇이 없고 내구도가 1 이상이면
						robot[i + 1] = true; // 이동
						robot[i] = false;
						belt[i + 1]--; // 내구도 감소
						if (belt[i + 1] == 0)
							cnt++;
					}
				}
			}
			off();
			
			// 3. 로봇 올리기
			if (belt[0] != 0) {
				robot[0] = true;
				belt[0]--;
				if (belt[0] == 0)
					cnt++;
			}

			result++;
		}
		System.out.println(result);
	}// end of main

	public static void off() { // 로봇 내리기 (회전하거나 이동할 때마다 체크해 줘야 됨)
		if (robot[N - 1])
			robot[N - 1] = false;
	}

}// end of class
