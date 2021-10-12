package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1520_내리막길_300ms {
	static int m,n;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
	static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken()); // 세로 
        n = Integer.parseInt(st.nextToken()); // 가로 
        map = new int[m][n];
        dp = new int[m][n]; // 현재 위치에서 목적지로 가는 경로의 개수

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // 방문한지 안한지 구분하기위해 -1로 초기화
            }
        }
        System.out.println(dfs(0, 0));
    }
    
    public static int dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) return 1;  // 목적지 도착 -> return 1
        if (dp[x][y] == -1) { // -1인 경우 -> 방문하지 않았다는 것 
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < m && ny < n && nx >= 0 && ny >= 0) { // 범위 체크
                	if (map[x][y] > map[nx][ny]) { // 현재 값이 더 큰 경우 -> 이동 가능 
                        dp[x][y] += dfs(nx, ny);
                    }
                } else continue;
            } 
        }
        return dp[x][y]; // 이동 가능한 경로의 수 
    }
}
