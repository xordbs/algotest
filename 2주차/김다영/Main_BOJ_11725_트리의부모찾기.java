package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_11725_트리의부모찾기 {
	static int N;
	static ArrayList<Integer>[] list;
	static int x, y;
	static boolean[] visited;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 노드의 개수
		visited = new boolean[N+1]; // 방문 여부 
		list = new ArrayList[N+1]; // 트리
		parents = new int[N+1]; // 부모노드 
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < N; i++) { // 연결된 노드 저장 
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		
		dfs(1); // 1이 루트노드 -> 1부터 dfs
		
		for(int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
		
	} // end of main
	
	private static void dfs(int num) { 
		visited[num] = true;
		
		for(int i : list[num]) {
			if(!visited[i]) { // 방문한적이 없으면 
				parents[i] = num; // 지금 노드가 부모노드가 된다.
				dfs(i);
			}
		}
	}
	
} // end of class
