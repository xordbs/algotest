package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2251_물통_인주비 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] v = new int[3]; // 부피 저장
		int[] current = new int[3]; // 현재 물 상황 저장
		
		// 0->1 , 0->2, 1->0, 1->2, 2->0, 2->1의 6가지 상황을 조건에 맞으면 계속 돌릴 수 있음.
		boolean[][] visited = new boolean[3][3]; // i번째 물통에서 j번째 물통으로 보냈을 때 true
		HashSet<Integer> three = new HashSet<>(); // 세번째 물통에 담겨있을 수 있는 물의 양 저장. 중복 제거하기 위해 HashSet 사용

		for (int i = 0; i < 3; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}

		current[2] = v[2];

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(2);

		int move = 0;

		while (q.size() > 0) {
			int c = q.poll();
			if (current[0] == 0)
				three.add(current[2]);

			for (int i = 0; i < 3; i++) {
				if (c != i && current[c] > 0 && !visited[c][i]) {
					if (current[c] + current[i] <= v[i]) {// 다 옮길 수 있음
						move = current[c];
						current[i] = move+current[i];
						current[c] = 0;
						visited[c][i] = true;
						q.offer(i);
					} else {// 다 못옮김
						move = v[i] - current[i];
						current[c] = current[c] - move;
						current[i] = v[i];
						visited[c][i] = true;
						q.offer(i);
					}

				}
			}
		} // end of bfs

		Iterator<Integer> iter = three.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
}
