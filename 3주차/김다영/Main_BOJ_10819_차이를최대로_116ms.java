package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10819_차이를최대로_116ms {
	static int N;
	static int[] A;
	static int[] arr;
	static boolean[] used;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 3 ≤ N ≤ 8
		A = new int[N]; // N개의 정수로 이루어진 배열 A
		arr = new int[N]; // 선택한 숫자를 저장할 임시 배열 
		used = new boolean[N]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0);
		
		System.out.println(max);
	}
	
	public static void perm(int cnt) { // 숫자를 순서대로 나열해서 최댓값을 찾는 것 -> 순열 사용 
		if(cnt == N) {
			int sum = 0;
			for(int i = 0; i < N - 1; i++) { 
				sum += Math.abs(arr[i] - arr[i+1]); // |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
			}
			max = Math.max(sum, max); // 최댓값 max에 저장 
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!used[i]) {
				arr[cnt] = A[i]; 
				used[i] = true;  
				perm(cnt + 1);
				used[i] = false;
			}
		}
	}
}
