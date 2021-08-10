package week1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_2309_일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[9]; // 난쟁이 9명 키 저장할 배열 생성 
		int sum = 0;
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
			sum += a[i]; // 난쟁이 9명 키 합 
		}
		
		Arrays.sort(a); 

		for(int i = 0; i < a.length - 1; i++) {
			for(int j = i + 1; j < a.length; j++) {
				if(sum - (a[i] + a[j]) == 100) { // 난쟁이 2명의 키 합을 9명 키 합에서 뺐을때, 100인 경우
					x = a[i]; 
					y = a[j]; // 가짜 난쟁이 값 저장 
					break;
				}
			}
		}
		for(int i = 0; i < a.length; i++) {
			if(a[i] == x || a[i] == y) {
				continue;
			}
			System.out.println(a[i]);
		}
	}
}
