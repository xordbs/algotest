package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * 184ms
 *
 */
public class Main_BOJ_15683_감시 {

	static int N, M,min = 100;
	static int[][] map;
	static ArrayList<CCTV> cctv = new ArrayList<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1}; // 시계방향
    static int[][][] alldir = { 
            {{0}, {1}, {2}, {3}}, // 1번
            {{0, 2}, {1, 3}}, // 2번
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번
            {{0, 1, 2}, {0, 1, 3}, {1, 2, 3}, {2, 3, 0}}, // 4번
            {{0, 1, 2, 3}} // 5번
    };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		map = new int[N][M];
		int result = N*M; // 공간의 크기 
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(str.nextToken());
				if (num != 0 && num != 6) {
					cctv.add(new CCTV(i,j,num)); // cctv면 add 
				}
				if(num == 6) result--; // 벽이면 감시대상에서 -- 
				map[i][j] = num;
			}
		}
		
		dfs(0, result-cctv.size(), map); // 감시대상에서 cctv 제외 하고 시작 
		
		System.out.println(min);
	}

	private static void dfs(int cnt, int result, int[][] map2) {
		if(cnt == cctv.size()) {
			min = Math.min(min, result);
			return;
		}
        int[][] copyMap = new int[N][M];
        copy(copyMap, map2);

		CCTV tv = cctv.get(cnt);
		
		for (int i = 0; i < alldir[tv.number-1].length; i++) { // cctv 번호별로 감시 체크 
			int chk = 0;
			for (int j = 0; j < alldir[tv.number-1][i].length; j++) { // cctv 별 감시 방향체크 
				int k = alldir[tv.number-1][i][j]; // 방향 

				int nr = tv.r;
				int nc = tv.c;
				
		        while(true) {
		        	nr += dr[k];
		        	nc += dc[k];
		            
		            // 범위 체크 및 벽 체크 
		            if(nr < 0 || nr >= N || nc < 0 || nc >= M || copyMap[nr][nc] == 6) break;
		            
		            // 다른 cctv 또는 이미 체크 됬으면 패스 
		            if((copyMap[nr][nc] >= 1 && copyMap[nr][nc] <= 5) || copyMap[nr][nc] == -1) continue;
		            
		            // 빈칸이면 체크 
		            copyMap[nr][nc] = -1;
		            chk++; // 감시가능으로 ++
		        }
			}
			dfs(cnt+1, result - chk, copyMap); // 반복 
			copy(copyMap, map2);
		}
	}

    private static void copy(int[][] copyMap, int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
            	copyMap[i][j] = map[i][j];
            }
        }
    }

	static class CCTV {
		int r, c, number;

		CCTV(int r, int c, int number) {
			this.r = r;
			this.c = c;
			this.number = number;
		}
	}
}
