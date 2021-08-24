package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로 {
	static int N;
	static int max = 0;
	static int[] arr;
	static boolean[] check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		check = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] answer = new int[N];
		perm(answer, 0);
		System.out.print(max);
	}
	public static void perm(int[] answer, int depth) {
		if(depth == N) {
			int sub =0;
			for(int i = 0; i<N-1; i++) {
				sub += Math.abs(answer[i]-answer[i+1]);
			}
			
			if(sub>max) max = sub;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if (!check[i]) {
				check[i] = true;                    // 중복 체크
				answer[depth] = arr[i];
				perm(answer, depth+1);
				check[i] = false;
			}
		}
	}
}
