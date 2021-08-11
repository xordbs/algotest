package 백준;

import java.util.Scanner;

public class Main_백준_2447_별찍기10_오윤택 {

	static String arr[][];
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		arr = new String[num][num];
		
		for (int i = 0; i < num; i++) { // 배열의 모든 공간을 공백으로 채우기
			for (int j = 0; j < num; j++) {
				arr[i][j] = " ";
			}
		}
		star(0,0,num);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	/**
	 * 배열의 좌표 값을 받고 입력받은 num 값을 index로 활용. 
	 * 처음을 큰 사각형으로 생각하고 그 안에서 num을 3으로 나눠 1일 될때까지 반복한다.
	 * 기본 별 모양을 보면 1,1에만 공백, 1,1이면 패스
	 * 
	 */
	public static void star(int r, int c, int index) {
		if(index == 1) {
			arr[r][c] = "*";
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(!(i == 1 && j == 1)) {
					int next = index/3;
					star(r + (i * next), c + (j * next), next);
				}
			}
		}
	}
}
