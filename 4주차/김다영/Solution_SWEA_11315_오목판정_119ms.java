package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_11315_오목판정_119ms {
	static int N;
	static char[][] map;
	static boolean check;
	static int[] dx = {-1, 0, 1, 1}; // 우상, 우, 우하, 하
	static int[] dy = {1, 1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
		
		for(int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine()); 
			map = new char[N][N];
			check = false;
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j); // 값 저장 
				}
			}
			
			for(int i = 0; i < N; i++) {		
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 'o') { // 돌이 나오면
						for(int d = 0; d < 4; d++) {
							int cnt = 1;
							for(int count = 1; count < 5; count++) {
								int nx = i + dx[d] * count;
								int ny = j + dy[d] * count;
								// 오목판을 벗어나지 않고, 돌이 있으면 count++ 
								if(nx >= 0 && nx < map.length && ny >= 0 && ny < map.length && map[nx][ny] == 'o') 
									cnt++;
							}
							if(cnt == 5) // 오목 확인 
								check = true;
						}
					}
				}
			}
			if(check) System.out.println("#" + tc + " YES");
			else System.out.println("#" + tc + " NO");
		}
	}
}
