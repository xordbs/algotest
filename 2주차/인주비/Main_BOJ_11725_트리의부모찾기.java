package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_11725_트리의부모찾기 {
	static int N;
	static ArrayList<Integer>[] list;
	static Stack<Integer> stack;
	static ArrayList<Integer> nodes;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws Exception {
		// 트리를 탐색할 때마다 부모의 값을 저장해 놓고 자식이 없으면 리턴돼서 올라오고 저장된 값을 출력한다
		// 트리를 구현하는 방법은?
		// 일단 꼭 부모부터 입력된다는 보장이 없기 때문에 양방향으로 저장을 해둔다

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		// 노드마다 어느 노드가 연결되어있는지 ArrayList로 저장한다
		// ArrayList로 저장하는 이유는? 몇개의 노드가 연결되어 있는지 모르기 때문에 배열을 할당할 수 없다
		list = new ArrayList[N + 1];
		stack = new Stack<Integer>();
		visited = new boolean[N+1];
		answer = new int[N+1];

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			list[node1].add(node2);
			list[node2].add(node1);
		}

		dfs(1);
		for (int i = 2; i < answer.length; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb);
	}

	// DFS 탐색
	// 1부터 시작해서 부모를 저장해 놓고 자식의 ArrayList를 체크한다.
	// 1부터 방문을 시작. 연결되어 있는 ArrayList 안의 원소를 체크해서 방문한 적이 없다면 그 원소의 부모는 현재 노드가 된다
	// node에 연결된 ArrayList 안의 원소가 방문한 적이 있으면 이미 나보다 높은 상태
	public static void dfs(int node) {
		visited[node] = true;
		for (int i : list[node]) {
			if (!visited[i]) {
				answer[i] = node;
				dfs(i);
			}
		}
	}
}
