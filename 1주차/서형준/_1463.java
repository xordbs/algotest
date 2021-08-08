package BAEKJOON;

import java.util.Scanner;

public class _1463 {
	static int cnt;
	static int min=Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		min(n);
		System.out.println(min);
	}

	public static void min(int n) {
		
		if(n==1) {
			if(min>cnt) {
				min = cnt;
			}
		}
		if(cnt<min && n>=6 && n%6==0) {
			cnt+=2;
			min(n/6);
			cnt+=2;
		}else if(cnt<min && n>2 && n%3==0) {
			cnt++;
			min(n/3);
			cnt--;
		}else if(cnt<min && n>1 && n%2==0) {
			cnt++;
			min(n/2);
			cnt--;
		}
		if(cnt<min && n>1) {
			cnt++;
			min(n-1);
			cnt--;
		}
	}
}
