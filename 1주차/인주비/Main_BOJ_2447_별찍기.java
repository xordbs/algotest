package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2447_별찍기 {
	static StringBuilder sb;
	static String[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		arr = new String[N][N];
		
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				arr[i][j] = " ";
		
		print(0, 0, N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(arr[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void print(int r, int c, int N) {
		if (N == 1) {
			arr[r][c] = "*";
			return;
		}
	
		// 크게 보면 총 [3][3]의 반복을 돌면 된다
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) // 가운데는 비워주고 
					continue;
				else // 아닌 부분은 옆으로 밑으로 보낸다
					print(r + i*(N/3), c + j*(N/3), N/3);
			}
		}
	}
}
