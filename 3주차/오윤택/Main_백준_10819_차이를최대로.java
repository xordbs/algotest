package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10819_차이를최대로 {
		static int N, max = Integer.MIN_VALUE;
		static int arr[], acp[];
		static boolean[] chk;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		acp = new int[N];
		chk = new boolean[N];
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		pur(0);
		System.out.println(max);
		
	}
	private static void pur(int cnt) {
		if(cnt == N) {
			deMax(N-1, 0); // 배열들의 차이 계산
			return;
		}
		// 순열 계산
		for (int i = 0; i < N; i++) {
			if(!chk[i]) {
				chk[i] = true;
				acp[cnt] = arr[i];
				pur(cnt+1);
				chk[i] = false;
			}
		}
	}
	
	private static void deMax(int cnt, int value) {
		for (int i = 1; i < N; i++) { // 1~ N-1까지  |(i-1)-(i)| 계산
			value += Math.abs(acp[i-1]-acp[i]);
		}
			max = max < value?value:max; // value 값 비교후 교체
	}
}
