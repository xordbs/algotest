package IM대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_11315_오목판정_D3 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int TC = Integer.parseInt(br.readLine());
		for (int a = 1; a <= TC; a++) {
			
			int N = Integer.parseInt(br.readLine());
			String answer = "NO";
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			for (int i = 0; i < map.length; i++) {
				int cnt = 0;
				for (int j = 0; j < map.length; j++) {
					if(map[i][j] == 'o') {
						cnt++;
						//우
						for (int k = 1; k < 5; k++) {
							if(j+k < N && map[i][j+k] == 'o') cnt++;
							else break;
						}
						if(cnt == 5) break;
						else cnt = 1;

						//우하
						for (int k = 1; k < 5; k++) {
							if(j+k < N && i+k < N && map[i+k][j+k] == 'o') cnt++;
							else break;
						}
						if(cnt == 5) break;
						else cnt = 1;
						
						//좌하
						for (int k = 1; k < 5; k++) {
							if(i+k < N &&  j-k >= 0 && map[i+k][j-k] == 'o') cnt++;
							else break;
						}
						if(cnt == 5) break;
						else cnt = 1;
						
						//하
						for (int k = 1; k < 5; k++) {
							if(i+k < N &&  map[i+k][j] == 'o') cnt++;
							else break;
						}
						if(cnt == 5) break;
						else cnt = 0;
					}
					
				}
				if(cnt == 5) {
					answer = "YES";
					break;
				}
			}
			System.out.println("#"+a+" "+answer);
		}
	}
}
