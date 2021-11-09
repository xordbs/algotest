package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14719_빗물_인주비 {
	/*
	 * 92ms
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] input = new int[W];
		int sum = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < W; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0, end = 0;
		int base = 0, current = 0;

		for (int i = 1; i < W - 1; i++) {
			// 현재 위치를 기준으로 왼쪽 최대벽 오른쪽 최대벽을 찾는다.
			current = input[i];
			start = i;
			end = i;

			for (int l = i - 1; l >= 0; l--) {
				if (input[l] > current && input[l] > input[start]) { // 현재 위치보다 높고 원래 왼쪽 벽 최대보다 높으면
					start = l; // 갱신
				}
			}

			for (int r = i + 1; r < W; r++) {
				if (input[r] > current && input[r] > input[end]) {
					end = r;
				}
			}
			
			// 더 낮은 쪽을 기준으로 차이를 계산
			if (input[start] < input[end]) 
				base = start;
			else 
				base = end;
			
			sum += (input[base] - input[i]);
		}

		System.out.println(sum);
	}
}
