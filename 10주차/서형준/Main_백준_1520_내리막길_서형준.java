package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1520_내리막길_서형준 { // 단순 dfs 16%까지 통과 그 이후 시간초과
	static int R,C,cnt;
	static int[][] arr;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt=0;
		dfs(0,0);
		
		System.out.print(cnt);
	}
	private static void dfs(int sr, int sc) {
		if(sr==R-1 && sc == C-1) {
			cnt++;
			return;
		}
		boolean check = false;
		for (int i = 0; i < 4; i++) {
			int or = sr + dr[i];
			int oc = sc + dc[i];
			if(or>=0 && or<R && oc>=0 && oc<C && arr[sr][sc] > arr[or][oc]) {
				dfs(or,oc);
				check = true;
			}
		}
		
		if(!check) {
			return;
		}
	}

}
