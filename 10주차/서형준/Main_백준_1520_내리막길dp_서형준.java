package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1520_내리막길dp_서형준 { // 단순 dfs 16%까지 통과 그 이후 시간초과 >> dp 배열을 만들어서 해당 위치에서 갈수있는방법을 저장해놓음
	static int R,C;	// 행 열 크기
	static int[][] arr,dp;	// 지도배열 , 해당위치에서 끝까지 가는 방법 저장하는 배열
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		dp = new int[R][C];
		for (int i = 0; i < R; i++) {	// 지도배열 초기화, dp배열 초기화
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1; // dp배열 -1로 하는 이유는 해당 위치에서 끝까지 갈수있는 경우가 0일수도 있기때문이고 음수는 dfs를 돌리며 나올수없다.
			}
		}
		
		System.out.print(dfs(0,0));
	}
	private static int dfs(int sr, int sc) {	// 해당위치에서 상하좌우를 탐색해 탐색된위치에서 끝까지 갈수있는 경우를 모두 더해주면 현재위치에서 갈수있는경우의수
		if(sr==R-1 && sc == C-1) { // 목적지인 경우
			return 1;
		}
		
		if(dp[sr][sc]!=-1) {	// 이미 탐색을 한경우 재탐색 방지
			return dp[sr][sc];
		}
		
		dp[sr][sc] = 0;	// 현재 위치에서 갈수있는 경우의수는 0으로 초기화
		for (int i = 0; i < 4; i++) {	// 상하좌우 탐색
			int or = sr + dr[i];
			int oc = sc + dc[i];
			if(or>=0 && or<R && oc>=0 && oc<C && arr[sr][sc] > arr[or][oc]) {
				dp[sr][sc] += dfs(or,oc);	// 현재위치에서 탐색된 위치에서 갈수있는 경우의수를 다더해준다
				// 탐색된 위치는 현재 -1 혹은 이미탐색한경우 n가지의 경우가 있음
				// -1인경우에는 dfs를 반복하여 해당 위치에서 갈수있는 경우의 수를 계속 구함
			}
		}
		
		return dp[sr][sc];	// 현재 위치에서 갈수있는 경우의수 리턴
	}

}
