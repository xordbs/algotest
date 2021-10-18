package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_17070_파이프옮기기1_264ms {
	static int N; // 집의 크기 
    static int[][] map; // 집의 상태 
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1}; // 오른쪽, 아래, 오른쪽 아래
    static int answer = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int d) {
        if (x == N - 1 && y == N - 1) { // 기저조건 
            answer++;
            return;
        }
        // d : 현재 방향 
        // d : 0 -> 가로 
        // d : 1 -> 세로
        // d : 2 -> 대각선
        // nd : 다음 방향
        for (int nd = 0; nd < 3; nd++) {
            if (d == 0 && nd == 1) continue; // 현재 가로 방향이고, 다음 방향이 세로이면 x
            if (d == 1 && nd == 0) continue; // 현재 세로 방향이고, 다음 방향이 가로이면 x

            int nx = x + dx[nd];
            int ny = y + dy[nd]; // 다음 좌표 

            if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || map[nx][ny] == 1) continue; // 범위를 벗어나거나 벽이 있을 때 x
            if (nd == 2 && (map[nx - 1][ny] == 1 || map[nx][ny - 1] == 1)) continue; // 다음 방향이 대각선일 때, 벽을 만났을 때 x

            dfs(nx, ny, nd); // 위의 모든 경우를 다 지나왔으면, 파이프 이동 가능 -> 다음 탐색
        }
    }
}
