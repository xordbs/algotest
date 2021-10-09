package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_백준_2667_단지번호붙이기_서형준 {	// java 11 = 120 , java 8 = 92
	static int N,cnt;	// N 지도크기, cnt 단지 갯수
	static int[][] arr;	// 지도 배열
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static Queue<int[]> q = new LinkedList<int[]>();	// 단지별 집의 갯수를 구하기위한 bfs에 사용할큐
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();	// 단지별 동의 갯수를 담을 스택
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]==1) {	// 아파트가 있는경우
					q.offer(new int[] {i,j});	// 시작 위치를 큐에 저장
					arr[i][j]=0;	// 큐에 담으면 0으로 변경
					cnt=1;	// 큐에 담을때마다 cnt 증가하므로 1부터 시작
					find(); // 단지별 집갯수 찾기위한 bfs
					stack.push(cnt); // cnt는 단지별 집의 갯수
				}
			}
		}
		int size = stack.size();	// 스택사이즈가 단지 갯수
		int[] sub = new int[size];	// 단지별 집의 갯수 정렬을 위해 배열 초기화
		for (int i = 0; i < size; i++) {
			sub[i] = stack.pop();
		}
		Arrays.sort(sub);	// 단지별 집의갯수 정렬
		sb.append(size).append("\n");	
		for (int i = 0; i < size; i++) {
			sb.append(sub[i]).append("\n");
		}
		System.out.println(sb);
		
	}

	private static void find() { // 현재 담긴 큐를 비워주며 그 큐에 담긴 집의 동서남북을 확인해 큐를 담아 새로운 큐로 다시 호출하는 작업
		if(q.size()==0) return;	// q에 담긴게 없으면 리턴
		int n = q.size();	// q에 담긴 사이즈
		for (int k = 0; k < n; k++) {	// 큐를 비워주기 위한 작업
			int[] sub = q.poll();	// 저장된 집의 인덱스 저장
			for (int i = 0; i < 4; i++) {	// 상하좌우 확인하고 
				int or = sub[0]+dr[i];
				int oc = sub[1]+dc[i];
				if(or>=0 && or<N && oc>=0 && oc<N && arr[or][oc]==1) {	// 집이있으면 
					arr[or][oc]=0;	// 해당집 0으로 변경후
					q.offer(new int[] {or,oc}); // q에 저장
					cnt++;	// 집의 갯수 증가
				}
			}
		}
		find();	// bfs 재호출
	}

}
