package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노_서형준 {	// java11 492ms

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 모든종류의 도형을 구했습니다..
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int[] num = new int[19];	//총 19종류의 도형
				if(j+3 < M) num[0] = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i][j+3];	// ㅡ
				if(i+3 < N) num[1] = arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+3][j]; // ㅣ
				if(j+1 < M && i+1 < N) num[2] = arr[i][j]+arr[i+1][j]+arr[i][j+1]+arr[i+1][j+1]; // ㅁ
				if(j+2 < M && i+1 < N) {
					int a = arr[i][j]+arr[i][j+1]+arr[i][j+2];
					num[3] = a+arr[i+1][j];		// 가로긴 ㄱ
					num[4] = a+arr[i+1][j+1];	// ㅜ
					num[5] = a+arr[i+1][j+2];	// 가로긴 ㄱ 대칭
					num[6] = arr[i][j]+arr[i+1][j+1]+arr[i+1][j+2]+arr[i+1][j]; // 가로긴 ㄴ모양
				}
				if(j-1 >=0 && i+1 <N && j+1 < M) num[7] = arr[i][j] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];	// ㅗ
				if(j-2 >=0 && i+1 <N) num[8] = arr[i][j] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j-2];	// 가로긴 ㄴ대칭
				if(i+1<N && j+2<M) num[9] = arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+1][j+2];	// z
				if(j-1>=0 && i+1<N && j+1<M) num[10] = arr[i][j]+arr[i][j+1]+arr[i+1][j]+arr[i+1][j-1];	// z대칭
				if(j+1<M && i+2<N) num[11] = arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+2][j+1];	// z대칭 세로
				if(i+2<N && j-1>=0) num[12] = arr[i][j]+arr[i+1][j]+arr[i+1][j-1]+arr[i+2][j-1];// z세로
				if(i+2<N && j+1 < M) {
					int a = arr[i][j] + arr[i+1][j] + arr[i+2][j];
					num[13] = a + arr[i][j+1]; // 세로긴ㄱ 대칭
					num[14] = a + arr[i+1][j+1];	// ㅏ
					num[15] = a + arr[i+2][j+1];	// 세로긴 ㄴ
				}
				if(i+2<N && j-1 >=0) {
					int a = arr[i][j] + arr[i+1][j] + arr[i+2][j];
					num[16] = a + arr[i][j-1];	// 세로긴 ㄱ
					num[17] = a + arr[i+1][j-1];	// ㅓ
					num[18] = a + arr[i+2][j-1];	// 세로긴 ㄴ 대칭
				}
 				int sum = 0;
				for (int k = 0; k < 19; k++) {	// 19종류중 가장 큰수 찾기
					sum = sum > num[k] ? sum : num[k];
				}
				max = max > sum ? max : sum;	// 현재 max와 비교하여 max 수정
			}
		}
		System.out.print(max);
	}

}
