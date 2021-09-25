package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질_서형준 {	// 272ms
	static int N;	// 수빈위치
	static int K;	// 동생위치
	static Queue<Integer> q = new LinkedList<Integer>();	// bfs위한 큐1
	static Queue<Integer> q1 = new LinkedList<Integer>();	// bfs위한 큐2
	static boolean[] visited = new boolean[100001];		// 방문 배열
	static boolean check;		// 찾았는지 확인하는 변수
	static boolean check2;		// 어떤 큐에 넣을지 정하는 변수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		if(N>K) System.out.print(N-K);	// 수빈이는 음수로는 무조건 한칸이동
		else if(N==K) System.out.print(0);		// 같을땐 바로끝 
		else {
			q.offer(N);		// 수빈위치 큐에넣음
			int cnt =0;		// 현재 층?
			while(true) {
				if(check) {	// 찾았을때 출력하고 끝
					System.out.print(cnt);
					break;
				}
				while(q.size()!=0) {	// q를 다비울때까지
					check2=true;	
					find(q.poll());
					if(check) break;	
				}
				if(!check) cnt++;	// 찾았으면 cnt 안올림
				while(q1.size()!=0) {
					check2=false;
					find(q1.poll());
					if(check) break;	
				}
				if(!check) cnt++;
			}
		}
	}
	private static void find(int num) {
		
		if(num==K) {	// 찾았으면 리턴
			check=true;
			return;
		}else if(num < 0 || num > 100000) return;	// 범위를 벗어나면 리턴
		if(visited[num]) return;	// 방문했으면 리턴
		else visited[num] = true;	// 첫방문이면 true로 바꿔주고 진행
		
		if(check2) {	// check2가 true 일때 q1채움
			q1.offer(num-1);
			q1.offer(num+1);
			q1.offer(num*2);
		}else {		// check2가 false일때 q채움
			q.offer(num-1);
			q.offer(num+1);
			q.offer(num*2);
		}
	}
}
