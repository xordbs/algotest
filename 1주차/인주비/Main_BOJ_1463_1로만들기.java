package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1463_1로만들기 {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		makeOne(N);
		System.out.println(arr[N]);
	}

	public static void makeOne(int N) {
		if (N == 1) { // N이 1일 때는 
			return; // 0번
		}

		arr[N] = arr[N-1] + 1; // 1을 빼기만 하는 경우가 가장 많은 경우이기 때문에 일단 이걸로 초기값을 쭉 넣어놓는다. 
		//+1을 하는 이유는 cnt를 하는것
		// 재귀를 돌면서 1까지 쭉 초기값이 넣어졌으니 다시 올라오면서
		if (N % 3 == 0) {  // 3으로 나눠지는 숫자는
			arr[N] = Math.min(arr[N], arr[N/3] + 1); // 1을 빼기만 하는 경우와 비교하여 최솟값을 배열에 넣는다
		}
		if (N % 2 == 0) { // 위와 동일
			arr[N] = Math.min(arr[N], arr[N/2] + 1);
		}
		
		makeOne(N-1);
	}
}
