package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_2784_가로세로퍼즐_88ms {
	static boolean[] isSelected;
	static int[] num;
	static String[] arr;
	static String[] Carr;
	static char[][] puz;
	static int flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new String[6];

		isSelected = new boolean[6];
		num = new int[3];
		puz = new char[3][3];
		for (int i = 0; i < 6; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr); // 만족하는 값이 두개 이상인 경우 사전순으로 선택을 위한 기본 배열 정렬

		per(0);
		
		if(flag == 1 ) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(puz[i][j]);
				}
				System.out.println();
			}	
		}else {
			System.out.println(0);
		}
		
	}
	private static void per(int cnt) { // 순열  
		if(cnt == 3) {
			if(flag == 0) {
				chk(num);
				return;
			}else { // flag가 1이면 더이상 빠른 순서의 답은 나올수 없으니 더이상 chk하지 않고 return
				return;
			}
			
		}
		for(int i=0;i<6;i++) { 
			if(!isSelected[i]) {
				num[cnt]=i;
				isSelected[i]=true;
				per(cnt+1);
				isSelected[i]=false;
			}	
		}
	}
	
	private static void chk(int[] numbers) {
		flag = 0; // flag 초기화
		Carr = new String[6];
		for (int i = 0; i < numbers.length; i++)  {
			String str = arr[numbers[i]];
			for (int j = 0; j < str.length(); j++) puz[i][j] = str.charAt(j); // puz배열에 한글자씩 담기 
		}
		
		// 순열의 조합으로 만들어진 puz 배열에서 가로 3단어 세로 3단어를 copy 배열에 저장 
		for (int i = 0; i < 6; i++) {
			if(i < 3) { //총 6개중 가로 3개
				String str = null;
				for (int j = 0; j < 3; j++) {
					str+= Character.toString(puz[i][j]);
				}
				Carr[i] = str.substring(4, str.length()); // null 제거
			}else { // 세로 3개
				String str = null;
				for (int j = 0; j < 3; j++) {
					str+= Character.toString(puz[j][i-3]);
				}
				Carr[i] = str.substring(4, str.length()); // null 제거
			}
			
		}
		/*
		 * 정렬의 이유 
		 * 기존 단어와 puz에 담긴 문자로 만든 단어의 배열 을 둘다 정렬해서 
		 * 두 배열의 단어와 순서가 모두 일치하면 사전순으로 가장 빠른 답이 나온다. 
		 */
		Arrays.sort(Carr); // copy 배열에 담은 단어를 정렬
		for (int i = 0; i < 6; i++) {
			if(!arr[i].equals(Carr[i])) return;
		}
		flag = 1; // 단어와 순서가 모두 맞다면 flag 변경
		
	}
}
