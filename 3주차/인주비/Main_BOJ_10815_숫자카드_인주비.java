package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_10815_숫자카드_인주비 {
	static int[] cards;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		cards = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		Arrays.sort(cards);
		
		int key = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			key = Integer.parseInt(st.nextToken());
			search(key);
		}
	}

	public static void search(int key) {
		int start = 0, end = cards.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (cards[mid] == key) {
				System.out.print("1 ");
				return;
			} else if (cards[mid] < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		// 못찾았다면
		System.out.print("0 ");
	}
}
