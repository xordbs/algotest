package 백준;
import java.util.Scanner;

public class Main_백준_1463_1로만들기 {

	static int num;
	static int min;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		sc.close();
		min = num;	
		
        makeOne(num, 0);
        System.out.println(min);  	
        	
	} // end of main
	
	private static void makeOne(int result, int cnt) {
		if(result == 1 ) {
			min = min > cnt? cnt: min; // cnt 값이 min 보다 작으면 min에 cnt 저장
			return;
		}
		if(cnt>= min) return; // cnt 값이 min 과 같거나 크다면 탈출
		
		if(result%2 == 0) {  // 입력 값이 2로 나눠지는 경우 먼저 탐색
			makeOne(result/2, cnt+1);
		}
		if(result%3 == 0) { // 입력 값이 3으로 나눠지는 경우 탐색
			makeOne(result/3, cnt+1);
		}
		makeOne(result-1, cnt+1); //  1을 뺴는 경우 탐색

	}
} // end of class
