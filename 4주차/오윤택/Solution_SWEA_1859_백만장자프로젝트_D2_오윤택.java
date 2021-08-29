package IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1859_백만장자프로젝트_D2_오윤택 {
	static int N;
	static int[] arr;
	static int e, max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			max = 0;
			e = 0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			long result = 0;
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(str.nextToken());
			}
			for (int k = 0; k < N; k++) {
				max(k, N); // start부터 N 까지의 최대값을 구한다. 
				for (int j = k; j < max; j++) { // 수익 계산
					if(arr[max]-arr[j] > 0) {
						result += arr[max]-arr[j];
					}
				}
				k = max;	// 최대 값을 구한 후 최대값 이후부터 마지막 까지의 최대값을 구하기 위해 최대값을 k로 변경 후 반복
			}
			System.out.println("#"+i+" "+result);
		}
	}
	
	private static void max(int start, int end) {
		max = start;
		for (int i = start; i < end; i++) {
			max = arr[max] < arr[i]?i:max;
		}
	}
}
