package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class _2447 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[][] arr = new String[N][N];		// N*N 배열
		for(int i=0; i<N; i++) {
			Arrays.fill(arr[i], "*");			// 전체 별로 초기화
		}
		star(N, arr, 0, 0);		

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void star(int n, String[][] arr, int r, int c) {	// arr배열, r,c부터 n*n크기만큼 채움
		if(n==1) {
			return;
		}
		for (int i = r+n/3; i < r+(n/3)*2; i++) {		// r,c에서 시작한 n*n크기 배열 가운데 n/3*n/3만큼 빈칸으로 채움 
			for (int j =  c+n/3; j < c+(n/3)*2; j++) {
				arr[i][j] = " ";
			}
		}
		for (int i=r; i<n+r; i = i+n/3) {		// n*n행렬은 n/3*n/3행렬 9개로 이루어짐 그래서 9번호출
			for (int j=c; j<n+c; j = j+n/3) {	// r,c를 놓은건 호출하는 배열인덱스를 다음 함수호출에 전달해주기 위함 
				star(n / 3, arr, i,j);
			}
		}
	}
}
