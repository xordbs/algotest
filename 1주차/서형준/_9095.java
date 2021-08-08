package BAEKJOON;

import java.util.Scanner;

public class _9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		int n;
		for(int tc=0; tc<T; tc++) {
			n= sc.nextInt();
			sb.append(sum(n)).append("\n");
		}
		System.out.print(sb);
	}

	public static int sum(int n) {
		if(n==1) {
			return 1;
		}else if(n==2) {
			return 2;
		}else if(n==3) {
			return 4;
		}else {
			return sum(n-3)+sum(n-2)+sum(n-1);	// n을 나타내는건 4부터 앞에 세개를 더하면됨
		}
	}
}
