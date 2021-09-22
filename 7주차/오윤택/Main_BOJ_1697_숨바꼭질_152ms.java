package ssafy_7wk;

import java.io.*;
import java.util.*;
/*
 * 조건 : 0 <= N,M <=100000
 * 0부터 100000으로 범위가 정해져 있기에 방문체크 배열을 100001크기로 선언
 * bfs를 통해 문제 해결
 */
public class Main_BOJ_1697_숨바꼭질_152ms {
	static int N,M, flag = 0, count;
	static LinkedList<Integer> q;
	static boolean[] visited = new boolean[100001];
	static int num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		q = new LinkedList<Integer>();
		count = 0;
		bfs();
		System.out.println(count);
		sc.close();
	}
	private static void bfs() {
		if(N == M ) { // 위치가 처음부터 같이 들어오는 경우 바로 종료 후 0 출력
			return;
		}
		q.add(N);
		while(true) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				num = q.poll();
				
				if(num+1 == M || num-1 == M || num*2 == M) {
					flag = 1;
					break;
				}
				if(num+1 <= 100000 && !visited[num+1]) {
					visited[num+1] = true;
					q.add(num+1);
				}
				if(num-1 >= 0 && !visited[num-1]) {
					visited[num-1] = true;
					q.add(num-1);
				}
				if(num*2 <= 100000 && !visited[num*2]) {
					visited[num*2] = true;
					q.add(num*2);
				}
			}
			count++;
			if(flag == 1)  break;
		}
	}
}
