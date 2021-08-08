package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Main_BOJ_2503_숫자야구 {

	static int N;
	static int[] input;
	static int[] numbers; // 정답이 될 수 있는 모든 경우를 뽑기 위함
	static boolean[] isSelected;
	static int[][] question; 
	static int[] strike;
	static int[] ball;
	static int sCnt;
	static int bCnt;
	static int result;
	static int answerCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		input = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		numbers = new int[3];

		isSelected = new boolean[input.length];

		question = new int[N][3];
		strike = new int[N];
		ball = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char[] temp = st.nextToken().toCharArray();
			
			for (int j = 0; j < 3; j++)
				question[i][j] = temp[j] - '0';
			
			strike[i] = Integer.parseInt(st.nextToken());
			ball[i] = Integer.parseInt(st.nextToken());
		}

		// 나올 수 있는 경우의 수는 총 504개 -> 상대적으로 작음. 그냥 다 돌려보자
		// 인덱스와 숫자까지 같으면 스트라이크, 숫자는 같은데 인덱스가 다르면 볼

		sCnt = 0;
		bCnt = 0;
		result = 0;
		answerCnt = 0;
		
		permutation(0);
		
		System.out.println(answerCnt);
	} // end of main

	private static void permutation(int cnt) {
		if (cnt == 3) { // 순열 결과가 나왔을 때 -> 3자리 수가 뽑혔을 때
			
			result = 0;
			
			for (int i = 0; i < N; i++) {

				sCnt = 0; // 테스트 케이스마다 스트라이크랑 볼은 달라지니까 0으로 바꿔 주기
				bCnt = 0;

				for (int j = 0; j < 3; j++)
					if (question[i][j] == numbers[j])
						sCnt++; 

				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (j == k) // 인덱스마저 같으면 스트라이크니까 제외시켜 주기
							continue;
						if (question[i][j] == numbers[k])
							bCnt++;
					}
				}

				if (sCnt == strike[i] && bCnt == ball[i]) // 한개의 테스트케이스를 만족하는 경우에 result++
					result++;

			} // end of for

			if (result == N) // 테스트케이스를 모두 만족하는 경우에
				answerCnt++; // 정답이 될 수 있다
			
			return;
		}

		for (int i = 0; i < input.length; i++) {
			if (isSelected[i])
				continue;

			numbers[cnt] = input[i];
			isSelected[i] = true;

			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}// end of class
