package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_7490_0만들기_104ms {
	
	static int N;
	static int index;
	static int sum;
//	static String plus, minus, blank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			sum = 0;
			String str = "1";
			index = Integer.parseInt(br.readLine());
			dfs(1,sum, 1, 1, str);
			System.out.println();
		}
	}
	/*
	 * 조건 :N은 3<=N<=9, 출력은 ASCII순서에 따라 출력, 부호별 ASCII순서(" ", "+", "-")
	 * 1~N까지 차례대로 계산, sign은 공백 문자 계산 때문에 필요, sign이 없으면 부호가 없이 공백으로 만 이루어진 값이 0으로 출력됨
	 */
	private static void dfs(int sign, int sum, int num, int next, String str) { // sign = 부호, sum = 계산 합, num = 계산되는 숫자, next = 다음 숫자, str 출력 저장문자
		if(next == index) {
			sum += (num*sign); // 들어온 번호가 N과 같을때 부호와 계산에 필요한 num을 곱하여 부호 결정 후 합계 계
			if(sum == 0) System.out.println(str);
			return;
		}
		String blank = str + " "+String.valueOf(next+1); 
		String plus = str + "+" + String.valueOf(next+1);
		String minus = str + "-" + String.valueOf(next+1);
		dfs(sign, sum, num*10 + (next+1), next+1, blank); //" "
		dfs(1, sum + num*sign, next+1, next+1, plus);  // +
		dfs(-1, sum + num*sign, next+1, next+1, minus); // -
	}
}
