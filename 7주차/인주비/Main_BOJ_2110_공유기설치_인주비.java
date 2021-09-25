package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2110_공유기설치_인주비 {
	/*
	 * 228ms
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] map = new int[N];

		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(map);

		// 집 사이의 거리 중 최소값은 1, 최대값은 첫번째 집과 마지막 집의 거리
		int min = 1;
		int max = map[N - 1] - map[0];
		int res = 0;

		// min 과 max 사이의 거리는 모두 가능성이 있으므로 그 거리들 중에 최대값을 이분탐색으로 찾아본다
		while (min <= max) {
			int mid = (min + max) / 2;
			int cnt = 1;
			int start = map[0];
			for (int i = 1; i < N; i++) {
				if (map[i] - start >= mid) { // map[i]와 공유기가 설치된 곳까지의 거리를 계산해 그 값이 mid보다 크다면 설치가 가능하다
					cnt++;
					start = map[i];
				}
			}

			if (cnt >= C) {
				res = mid;
				// 최대값을 찾아야 되니까 더 넓은 거리에서도 가능한지 확인해야 함. 이분탐색이므로 min값을 mid+1로 바꿔줌
				min = mid + 1;
			} else { // 설치 불가능
				// 더 좁은 거리에서 확인해야 함
				max = mid - 1;
			}
		}
		System.out.println(res);
	}
}
