package week1;

import java.util.Scanner;

public class Main_BOJ_9095_123더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스의 개수
		int[] a = new int[11];
		
		a[1] = 1;
		a[2] = 2;
		a[3] = 4;
		
		for(int i = 4; i < a.length; i++) {
			a[i] = a[i-1] + a[i-2] + a[i-3];
		}
		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			System.out.println(a[n]);
		}
	}

}
