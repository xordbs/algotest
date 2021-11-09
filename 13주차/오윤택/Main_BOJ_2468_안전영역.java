package ssafy_13wk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 * 196ms
 *
 */
public class Main_BOJ_2468_안전영역 {
	
	static int N, maxValue;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0}; // 상하좌우
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		maxValue = 0; 
		for (int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				maxValue = maxValue >= map[i][j]?maxValue:map[i][j]; // 가장 높은 곳의 높이 저장
			}
		} // 입력 끝
		int result = 0; // 최종 결과 입력 변수
		for (int k = 0; k <= maxValue; k++) { // 가장 높은 위치까지 차례로 잠김
			visited = new boolean[N][N];
			int cnt = 0; // 높이별 결과 입력 변수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j] > k) { // 한번도 방문하지 않았고 물의 높이보다 높은곳
						cnt+= dfs(i,j,k); // dfs로 반환되는 1을 더한다.
					}
				}
			}
			result = result >= cnt?result:cnt;
		}
		System.out.println(result);
		
	}
	private static int dfs(int i, int j, int k) {
		visited[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if(visited[nr][nc]) continue;
			if(map[nr][nc] > k) dfs(nr,nc, k); //물에 잠기지 않았고 방문하지 않은 연결된 공간으로 이동
		}
		return 1;
	}
}
