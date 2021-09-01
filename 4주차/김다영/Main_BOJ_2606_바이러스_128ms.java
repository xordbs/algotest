package week4;

import java.util.Scanner;

public class Main_BOJ_2606_바이러스_128ms {
	static int N, M;
	static int[][] com;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 컴퓨터의 수
		M = sc.nextInt(); // 연결되어 있는 컴퓨터 쌍의 수

		com = new int[N + 1][N + 1];
		visited = new boolean[N + 1]; // 방문 체크 

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			com[x][y] = 1;
			com[y][x] = 1;// 연결된 컴퓨터를 1로 초기화
		}

		dfs(1); // 1번 컴퓨터부터 dfs 호출 
		
		System.out.println(cnt);
		
		sc.close();
	}

	static void dfs(int num) {
		visited[num] = true;

		for (int i = 1; i < N + 1; i++) {
			if (!visited[i] && com[num][i] == 1) { // 방문하지 않고, 연결되어있으면
				cnt++;
				dfs(i); // 그 컴퓨터에서 또 dfs 호출 
			}
		}
	}
}
