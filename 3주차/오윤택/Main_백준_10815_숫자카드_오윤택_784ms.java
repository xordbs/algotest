package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10815_숫자카드_오윤택_784ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 가지고 있는 N개 정수 입력
		int N = Integer.parseInt(br.readLine());
		int[] Nnum = new int[200000001]; // -1000000 ~ 10000000 까지니까 두배 크기의 배열 생성
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		/*
		 * 20000001의 크기의 배열 생성후 
		 * 양수인 경우는 10000000을 더한 위치에 값을 저장 10000001 ~ 20000000 까지 저장가능, 0은 0에 저장
		 * 음수인 경우는  값에 절대값을 씌운 위치에 저장 1 ~ 10000000 까지 저장가능
		 */
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(str.nextToken()); // 가지고 있는 카드의 값
			if(n >0)  Nnum[10000000+n] = n;
			else Nnum[Math.abs(n)] = Math.abs(n);
		}

		// 비교대상 M 개의 정수 입력
		int M = Integer.parseInt(br.readLine());
		int[] Mnum = new int[M];
		str = new StringTokenizer(br.readLine(), " ");

		/*
		 * 양수인 경우는 10000000을 더한 위치에 값과 입력값을 비교해서 일치하면 1 아니면 0
		 * 음수인 경우는  입력값에 절대값을 씌운 위치에 저장한 값과 비교하여 일치하면 1 아니면 0 
		 */
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(str.nextToken()); // 입력값
			if(n >0) {
				if(Nnum[10000000+n] == n) sb.append(1).append(" ");
				else sb.append(0).append(" ");
			}else {
				if(Nnum[Math.abs(n)] == Math.abs(n))  sb.append(1).append(" ");
				else  sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
		
	}
}
