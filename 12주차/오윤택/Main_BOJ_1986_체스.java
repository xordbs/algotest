package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 136ms
 *
 */
		
public class Main_BOJ_1986_체스 {
	static int[][] q, k;
	static int[][] chked;

	static int[] drq = { -1, -1, 0, 1, 1,  1,  0, -1 }; // 시계방향 
	static int[] dcq = {  0,  1, 1, 1, 0, -1, -1, -1 };
	static int[] drk = {-2, -2, -1, 1, 2,  2,  1, -1}; // 시계방향 
	static int[] dck = {-1,  1,  2, 2, 1, -1, -2, -2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		chked = new int[N][M];
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			str = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(str.nextToken());
			switch (i) {
			case 0:
				q = new int[n][2];
				break;
			case 1:
				k = new int[n][2];
				break;
			case 2:
				break;
			}
			for (int j = 0; j < n; j++) {
				int r = Integer.parseInt(str.nextToken()) - 1;
				int c = Integer.parseInt(str.nextToken()) - 1;
				switch (i) {
				case 0:
					chked[r][c] = 1;
					q[j][0] = r;
					q[j][1] = c;
					break;
				case 1:
					chked[r][c] = 2;
					k[j][0] = r;
					k[j][1] = c;
					break;
				case 2:
					chked[r][c] = 3;
					break;
				}
			}
		} // 입력 끝

		// q 먼저 구현
		for (int i = 0; i < q.length; i++) {
			for (int j = 0; j < 8; j++) {
				int nr = q[i][0] + drq[j];
				int nc = q[i][1] + dcq[j];
				
	            while (true) { //q는 8방 으로 0~ N, 0~M 까지 다 갈수 있으므로 while 처리 
	            	if(nr < 0 || nc < 0 || nr >= N || nc >= M || chked[nr][nc] > 0) break;
	                chked[nr][nc] = -1; //방문 체크 
	                nr += drq[j];
	                nc += dcq[j];
	            }
			}
		}
		
		//k 구현
		for (int i = 0; i < k.length; i++) {
			for (int j = 0; j < 8; j++) {
				int nr = k[i][0] + drk[j];
				int nc = k[i][1] + dck[j];
				
            	if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            	if(chked[nr][nc] == 0) {
            		chked[nr][nc] = -1; //방문 체크
            	}
            	
			}
		}
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (chked[i][j] == 0)
                    cnt++;
		
		System.out.println(cnt);
	}
}

//4 4
//2 1 4 2 4
//1 1 2
//1 2 3
