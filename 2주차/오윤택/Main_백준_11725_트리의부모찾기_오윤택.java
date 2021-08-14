package 백준;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_11725_트리의부모찾기_오윤택 {
	
	static int parents[];
	static ArrayList[] al;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		parents = new int[num + 1];
		al = new ArrayList[num+1];

		for (int i = 0; i < num + 1; i++) {
			al[i] = new ArrayList<>(); //
		}

		for (int i = 0; i < num - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			al[a].add(b); // 연결된 노드끼리 저장
			al[b].add(a); // 연결된 노드끼리 저장
		}
		
		Search();
		
		for (int i = 2; i < num + 1; i++) {
			System.out.println(parents[i]);
		}
	}

	//bfs
	static void Search() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		parents[1] = 1;

		while (!q.isEmpty()) {
			int current = q.poll();

			for (int i = 0; i < al[current].size(); i++) {
				int value = (int) al[current].get(i);
				if(parents[value] == 0) {
					q.offer(value);
					parents[value] = current;
				}
			}
		}

	}
}
