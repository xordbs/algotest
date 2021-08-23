package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14888_연산자끼워넣기_오윤택_620ms {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] numbers;
	static int[] calc;
	static int[] ccp;
	static boolean[] isSelected;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(str.nextToken());
		}
		str = new StringTokenizer(br.readLine()," ");
		calc = new int[N-1];
		ccp = new int[N-1];
		isSelected = new boolean[N-1];
		int index = 0;
		for (int i = 1; i <= 4; i++) {
			int n = Integer.parseInt(str.nextToken());
			for (int j = 0; j < n ; j++) {
				calc[index++] = i;
			}
		}
		
		per(0);
		System.out.println(max);
		System.out.println(min);
		
	}

	private static void per(int cnt) {
		if(cnt == N-1) {
			calc(0, numbers[0]);
			return;
		}
		
		for (int i = 0; i < N-1; i++) {
			if(!isSelected[i]) {
				isSelected[i]=true;
				ccp[cnt] = calc[i];
				per(cnt+1);
				isSelected[i]=false;
			}
		}
		
	}
	
	private static void calc(int cnt, int num) {
		
		for (int i = 0; i < N-1; i++) {
			switch (ccp[i]) {
			case 1: num = num + numbers[i+1]; break;
			case 2: num = num - numbers[i+1]; break;
			case 3: num = num * numbers[i+1]; break;
			case 4: num = num / numbers[i+1]; break;
			}
		}
		max = max < num?num:max;
		min = min > num?num:min;
	}
	
	
}
