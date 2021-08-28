package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1859_백만장자프로젝트_453ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = arr[n - 1]; // 맨 마지막 날 가격을 최댓값으로 둔다.
			long sum = 0;
			
			for(int i = n - 2; i >= 0; i--) {
				if(arr[i] > max) { // 비용이 최댓값보다 크면 
					max = arr[i]; // 최댓값을 그날의 비용으로 -> 물건을 팔지 x 
				} else { // 비용이 최댓값보다 작으면  
					sum += max - arr[i]; // 물건을 판다. 
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
		br.close();
	}
}
