package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14501_퇴사 {
	static int N;
	static int[] T, P;
	static int max = Integer.MIN_VALUE; // 최대 이익 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 퇴사 전 남은 날짜 
		T = new int[N]; // 상담을 완료하는데 걸리는 기간 
		P = new int[N]; // 상담을 했을 때, 받을 수 있는 금액 
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		System.out.println(max);
	}
	static void dfs(int idx, int sum) {
		if(idx > N) { // idx가 N보다 커지면 종료. 
			max = Math.max(max, sum);
			return;
		}
		if(idx + T[idx] <= N) { // idx일이 n일까지 끝낼 수 있으면, 
			dfs(idx + T[idx], sum + P[idx]); // 상담 기간과 금액을 더해 다음 날짜로 
		}
		dfs(idx + 1, sum); // 일을 하지 않는 경우, +1일 
	}
}
