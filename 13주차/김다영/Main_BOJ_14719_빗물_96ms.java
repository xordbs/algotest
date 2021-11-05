package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14719_빗물_96ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken()); // 세로 
		int W = Integer.parseInt(st.nextToken()); // 가로 
		
		int[] arr = new int[W];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		
		for(int i = 1; i < W - 1; i++) { // 첫번째, 마지막 블록 제외 
			int left = 0;
			int right = 0;
			
			for(int j = 0; j < i; j++) {
				left = Math.max(arr[j], left);
			}
			
			for(int j = i + 1; j < W; j++) {
				right = Math.max(arr[j], right); 
			}
			
			// 현 위치가 두 블럭보다 낮으면,
			// 두 블럭 중 낮은 기둥 기준으로 현위치 높이만큼 뺌 -> 고이는 빗물 양
			if(arr[i] < left && arr[i] < right) {
				cnt += Math.min(left, right) - arr[i];
			}
		}
		
		System.out.println(cnt);
		
	}
}
