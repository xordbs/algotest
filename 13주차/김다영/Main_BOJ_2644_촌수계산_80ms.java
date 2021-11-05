package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2644_촌수계산_80ms {
	static int n, x, y, m;
	static int[][] map;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); // 전체 사람 수 
		st = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine()); // 부모 자식간의 관계 개수 
		
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}
		
		dfs(x, 0);
		if(cnt > 0) System.out.println(cnt);
		else System.out.println(-1);
		
	}
	
	public static void dfs(int s, int depth) {
		if(s == y) {
			cnt = depth;
			return;
		}
		visited[s] = true;
		for(int i = 1; i <= n; i++) {
			if(map[s][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i, depth + 1);
				visited[i] = false;
			}
		}
	}
}
