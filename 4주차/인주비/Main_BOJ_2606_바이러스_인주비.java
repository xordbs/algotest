package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BOJ_2606_바이러스_인주비 {
	/*
	 84ms
	 */
	static int N;
	static boolean[] visited;
	static LinkedList<LinkedList<Integer>> graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		graph = new LinkedList<>();

		for (int i = 0; i < N + 1; i++) {
			graph.add(new LinkedList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		visited = new boolean[N + 1];
		dfs(1);

		int cnt = 0;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				cnt++;
		}
		System.out.println(cnt-1); // 1번 컴퓨터 빼줌
	} // end of main

	public static void dfs(int current) {
		visited[current] = true;
		for (int i = 0; i < graph.get(current).size(); i++) {
			if (!visited[graph.get(current).get(i)]) {
				dfs(graph.get(current).get(i));
			}
		}
	}
}
