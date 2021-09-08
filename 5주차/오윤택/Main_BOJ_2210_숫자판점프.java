package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BOJ_2210_숫자판점프 {
	
	static int[][] map;
	static int dr[] = {1,-1,0,0}; // 상하좌우
	static int dc[] = {0,0,1,-1};
	static HashSet<String> hs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		hs = new HashSet<String>();
		for (int i = 0; i < 5; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		String sixNum = new String();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i,j,0,sixNum);
			}
		}
		System.out.println(hs.size());
	}
	private static void dfs(int i, int j, int cnt, String sixNum) {
		if(cnt == 6) {
			hs.add(sixNum);
			return;
		}
		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k]; 
			int nc = j + dc[k]; 
			
			if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
				continue;
			}
			dfs(nr, nc, cnt+1, sixNum+map[i][j]);
		}
	}
}
