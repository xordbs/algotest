package ssafy_13wk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 104ms
 * 완탐
 * 거꾸로 생각
 */
public class Main_BOJ_14718_빗물 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(str.nextToken());
		int b = Integer.parseInt(str.nextToken());
		int[][] map = new int[a+1][b+1];
		int result = 0;
		str = new StringTokenizer(br.readLine());
		for (int i = 1; i < b+1; i++) {
			int temp = Integer.parseInt(str.nextToken());
			for (int j = 1; j <= temp; j++) {
				map[j][i] = 1;
			}
		}
		
		for (int i = 1; i < a+1; i++) {
			boolean flag = false;
			int count = 0;
			for (int j = 1; j < b+1; j++) {
				
				// 선택된 공간의 값이 1이면 flag true
				if(map[i][j] == 1)  flag = true;
				// flag가 true이고 선택된 공간이 0이면 빗물이 고일수 있음
				if(flag == true && map[i][j] == 0) count++;
				// 빗물이 한 공간이라도 고인상태이고 선택된 공간이 1이면 result에 count를 더해주고 0으로 변경
				if(count > 0 && map[i][j] == 1) { 
					result +=count;
					count = 0;
				}
			}
			
		}
		
		System.out.println(result);
		
	}
}
