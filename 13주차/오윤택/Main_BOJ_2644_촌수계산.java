package ssafy_13wk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * 76ms
 *
 */
public class Main_BOJ_2644_촌수계산 {
	static List<Integer>[] list;
	static boolean[] chked;
	static int a, b, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 총 명수
		StringTokenizer str = new StringTokenizer(br.readLine());
		a = Integer.parseInt(str.nextToken()); // 시작
		b = Integer.parseInt(str.nextToken()); // 종료
		int M = Integer.parseInt(br.readLine()); // 관계수
		list = new ArrayList[N+1];
		chked = new boolean[N+1];
		for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		result = -1;
		dfs(a, 0, chked);
		System.out.println(result);
	}
	private static void dfs(int value, int cnt, boolean[] visited) {
		if(value == b) {
			result = cnt;
			return;
		}
		for (int i = 0; i < list[value].size(); i++) {
			if(visited[list[value].get(i)]) continue;
			visited[list[value].get(i)] = true;
			dfs(list[value].get(i), cnt+1, visited);
		}
		
	}
}
