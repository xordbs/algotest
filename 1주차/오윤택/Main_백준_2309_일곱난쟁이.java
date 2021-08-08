package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_2309_일곱난쟁이 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[9]; // 난쟁이 수 크기로 배열 생성
		int sum = 0; // 난쟁이 9명의 키를 더할 변수 생성
		int fake = 0, fake2 = 0; // 가짜 난쟁이의 번호를 저장할 변수 생성
		for (int i = 0; i < arr.length; i++) { // 난쟁이의 키를 배열로 받고 키의 합을 구한다.
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr); // 오름차순 출력을 위한 정렬
		for (int i = 0; i < arr.length; i++) { // 난쟁이 2명의 키를 더한 경우의 수를 계산하여 총합에서 뺸다.
			for (int j = i+1; j < arr.length; j++) { // 같은수를 두번 더할수 없으니 i인덱스에 +1
				if(sum-(arr[i]+arr[j]) == 100) {
					fake = i;
					fake2 = j;
					break;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) { // 가짜 난쟁이를 제외하고 출력
			if(i != fake && i != fake2) {
				System.out.println(arr[i]);
			}
		}
		sc.close();
	} // end of main
} // end of class


/*
20
7
23
19
10
15
25
8
13
*/