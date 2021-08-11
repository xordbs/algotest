package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_2503_숫자야구_오윤택 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		int list[] = new int[988];
		
		for (int i = 0; i < TC; i++) {
			
			String num = sc.next();
			int askSt = sc.nextInt();
			int askBall = sc.nextInt();
			
			int[] arr = new int[3];
			
			for (int j = 0; j < arr.length; j++) {
				arr[j] = num.charAt(j)-'0';
			}
			
			for (int j = 123; j <= 987; j++) { // 가능한 수인 123부터 987까지 반복
				int one = j/100;
				int two = (j-(one*100))/10;
				int three = j-(one*100)-(two*10);
				int strike = 0;
				int ball = 0;
				
				// 0이 들어올수 없고 세개의 값이 같은지 검사
				if(two == 0 || three == 0 || one == two || one == three || two == three) continue;
				
				// 첫번째 자리 비교
				if(arr[0] == one) strike++;
				if(arr[0] == two || arr[0] == three) ball++;
				
				// 첫번째 자리 비교
				if(arr[1] == two) strike++;
				if(arr[1] == one || arr[1] == three) ball++;
				
				// 첫번째 자리 비교
				if(arr[2] == three) strike++;
				if(arr[2] == one || arr[2] == two) ball++;
					
				// 비교후 입력받은 값과 동일하다면 ++
				if(strike == askSt && ball == askBall) {
					list[j]++; 
				}
				
			}
			
			
		}
		int count = 1;
		Arrays.sort(list);
		
		for (int i = list.length-1; i >= 0; i--) {
			if(list[i] == list[i-1]) { // 가장 큰 값의 갯수를 가져온다.
				count++;
			}else {
				System.out.println(count);
				break;
			}
		}
		sc.close();
	}

}
