package 백준;

import java.util.Scanner;

public class Main_백준_14501_퇴사 {
	static int N, MaxPay = 0;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		bye(0, 0);
		System.out.println(MaxPay);
		
		
	}
	
	private static void bye(int cnt, int val) {
		if(cnt >= N) { // cnt가 퇴사일보다 크면 max 값 비교
			MaxPay = MaxPay < val?val:MaxPay;  
			return;
		}
		// cnt에 상담기간을 더한 값이 퇴사일 보다 작다면 현재 일수에 상담기간을 더해 cnt로 넘겨주고 val또한 넘겨준다
		if(cnt+arr[cnt][0] <= N) bye(cnt+arr[cnt][0], val+arr[cnt][1]);  
		
		// 첫째날부터가 아니라 둘쨰날 부터, 셋쨰날부터 일하는게 최고의 페이일 수도 있으므로 모든 조합을 계산해본다.
		bye(cnt+1, val);
		
	}

}
