package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2448_별찍기11 {
	static String[][] str;
	static int N;
	static int N2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		N2 = N*2-1;
		int N3 = N-1;
		str = new String[N][N2];
		for (int i = 0; i < N; i++) {	// 전체 별로 초기화
			Arrays.fill(str[i], "*");
		}
		
		for (int i = 0; i < N3; i++) {	// 삼각형만 남게 빈칸
			for(int j=0; j<N3-i; j++) {
				str[i][j] = " ";
				str[i][N2-j-1] = " ";
			}
		}
		pang(N,0,N-1);	// 빈칸 만들기 시작
		
		for (int i = 0; i < N; i++) {
			for(int j=0; j<N2; j++) {
				sb.append(str[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static void pang(int n, int r, int c ) {	// n 변의길이, r 삼각형 꼭지점 행, c 삼각형 꼭지점 열
		if(n==3) {	// 3일때 가운데만 한칸 만들어주고 리턴
			str[r+1][c] = " ";
			return;
		}
		int n2 = n/2;	// 삼각형 반씩 나눠지니까
		int r2 = r+n-1;	// 해당 삼각형 밑변
		int cnt = 0;
		for(int i=r2; i>=r+n2; i--) {	// 밑변부터 올라오면서
			for (int j = 0; j <= cnt; j++) {	// 점점 열의갯수 증가하며 빈칸만들어줌
				str[i][c-j]=" ";
				str[i][c+j]=" ";
			}
			cnt++;
		}
		
		pang(n2,r,c);	// 큰삼각형중 윗부분 작은삼각형
		pang(n2,r+n2,c-n2);	// 큰삼각형중 왼쪽아랫부분 작은삼각형
		pang(n2,r+n2,c+n2);	// 큰삼각형중 오른쪽아랫부분 작은삼각형
	}
}



