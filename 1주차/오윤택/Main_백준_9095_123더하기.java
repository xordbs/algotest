package 백준;


import java.util.Scanner;

public class Main_백준_9095_123더하기 {
	static int N;
	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int i = 0; i < TC; i++) {
			N = sc.nextInt();
			
			if(N == 0) {
				System.out.println(N);
			}else {
				ottSum(0, 0);
				System.out.println(result);
			} // end of if
			result = 0;
		}
		sc.close();
	} // end of main

	public static void ottSum(int num, int cnt) {
		if(num == N) {
			result++;
			return;
		}
		
		if(num+1 <= N ) {
			ottSum(num+1, cnt+1);
		}
		if(num+2 <= N ) {
			ottSum(num+2, cnt+1);
		}
		if(num+3 <= N ) {
			ottSum(num+3, cnt+1);
		}
	} // end of ottSum
} // end of class
