package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	static int ans;	// 처음은 고정
	static int N;
	static int[] opr;
	static int[] arr;
	static boolean[] check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		check = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		opr = new int[N-1];
		st = new StringTokenizer(br.readLine()," ");
		int cnt=0;
		for (int i = 1; i <= 4; i++) {
			int check = Integer.parseInt(st.nextToken());
			for(int j=0; j<check; j++) {
				opr[cnt++] = i;
			}
		}
		ans = arr[0];
		
		int[] answer = new int[N-1];
		perm(answer, 0, N-1);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void perm(int[] answer, int depth, int n) {
		if(depth == n) {
			int sub = arr[0];
			for(int i=0; i<n; i++) {
				if(answer[i]==1) {
					sub += arr[i+1];
				}else if(answer[i]==2) {
					sub -= arr[i+1];
				}else if(answer[i]==3) {
					sub *= arr[i+1];
				}else if(answer[i]==4) {
					sub /= arr[i+1];
				}
			}
			if(sub>max) max = sub;
			if(sub<min) min = sub;
			return;
		}
		
		for(int i=0; i<n; i++) {
			if (!check[i]) {
                check[i] = true;                    // 중복 체크
                answer[depth] = opr[i];
                perm(answer, depth+1, n);
                check[i] = false;
            }
		}
	}

}
