package 서울_9반_서형준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_장기포 {
	static int N;
	static int[][] arr;
	static boolean[][] bool;
	static int count;
	
	public static void main(String[] args) throws Exception {	// DFS
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			bool = new boolean[N][N];
			count = 0;
			int r=0,c=0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 2) {	// 최초 포의 위치
						r = i;
						c = j;
					}
				}
			}

			find(r,c,0);	// DFS
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.print(sb);
	}
	static void find(int sr, int sc, int cnt) {	// sr, sc, cnt 포의위치, 포의 현재 이동수
		if(cnt==3) {
			return;
		}

		int check = 0;
		for (int i = sr-1; i >= 0; i--) {	// 위로 갈수있는 경우의수
			if(arr[i][sc] == 1) {
				check++;
				if(check==2) {	// 알을 잡았을경우
					arr[i][sc] = 0;
					if(!bool[i][sc]) {	// 이미 잡은알인지 확인 // 매번 돌떄마다 잡은알은 다시 생겨야하기때문
						bool[i][sc] = true;	// 잡은알로 넣고
						count++;	// count 증가
					}
					find(i,sc,cnt+1);	// 알을 잡고 현재 포의 위치를 기준으로 dfs
					arr[i][sc] = 1;	// dfs 가끝나고 잡은알 다시 만들어놓기
					break;
				}
			}else if(check==1) {
				find(i,sc,cnt+1);
			}
		}
		check=0;
		for (int i = sr+1; i < N; i++) {	// 아래로 갈수있는 경우의수
			if(arr[i][sc] == 1 ) {
				check++;
				if(check==2) {
					arr[i][sc] = 0;
					if(!bool[i][sc]) {
						bool[i][sc] = true;
						count++;
					}
					find(i,sc,cnt+1);
					arr[i][sc] = 1;
					break;
				}
			}else if(check==1) {
				find(i,sc,cnt+1);
			}
		}
		check=0;
		for (int i = sc-1; i >= 0; i--) {	// 좌로 갈수있는 경우의수
			if(arr[sr][i] == 1) {
				check++;
				if(check==2) {
					arr[sr][i] = 0;
					if(!bool[sr][i]) {
						bool[sr][i] = true;
						count++;
					}
					find(sr,i,cnt+1);
					arr[sr][i] = 1;
					break;
				}
			}else if(check==1) {
				find(sr,i,cnt+1);
			}
		}
		check=0;
		for (int i = sc+1; i < N ; i++) {	// 우로 갈수있는 경우의수
			if(arr[sr][i] == 1) {
				check++;
				if(check==2) {
					arr[sr][i] = 0;
					if(!bool[sr][i]) {
						bool[sr][i] = true;
						count++;
					}
					find(sr,i,cnt+1);
					arr[sr][i] = 1;
					break;
				}
			}else if(check==1) {
				find(sr,i,cnt+1);
			}
		}
	}
}
