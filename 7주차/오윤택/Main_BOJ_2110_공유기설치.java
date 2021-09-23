package BOJ;

import java.util.*;

/*
 * 764ms
 */
public class Main_BOJ_2110_공유기설치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int C = sc.nextInt();
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int start = 1; // 가질 수 있는 가장 작은 거
		int end = arr[N-1] - arr[0]; // 가질 수 있는 가장 긴 거리
		int result = 0;
		
		while(start <= end) {
			int mid = (end+start)/2; // 중간값 계
			int temp = arr[0]; // 가장 첫번쨰 자리에 공유기 설치 
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				// 시작점과 끝점의 중간 지점 보다 현재 설치 지점과
				// 이전 설치 지점의 차이가 더 크다면 공유기를 설치해주고 계산 위치 변
				if(arr[i]-temp >= mid) { 
					temp = arr[i];
					cnt++;
				}
			}
			// 공유기 갯수가 입력받은 공유기 설치 갯수와 일치하거나 보다 크면
			// 시작위치를 중간값보다 1만큼 큰 값으로 변경
			// 아니라면 끝나는 지점의 위치를 중간값보다 1만큼 작은 값으로 변
			if(cnt >= C) {
				start = mid + 1;
				result = mid;
			}else {
				end = mid-1;
			}
		}
		System.out.println(result);
		sc.close();
	}
}
