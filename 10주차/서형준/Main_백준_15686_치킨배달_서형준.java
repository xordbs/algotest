package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_15686_치킨배달_서형준 {	// java11 175ms, java8 128ms
	static int N,M,min,ho,ch;	// 도시크기, 남는치킨집갯수, 치킨거리최솟값, 현재 집의 갯수, 현재 치킨집 갯수
	static int[][] arr;	// 도시 배열
	static int[][] chi,hou,sub;	// 치킨집 인덱스 배열, 집 인덱스 배열, 집마다 치킨집 거리 배열
	static int[] number,input; // 조합을 위한 배열, 치킨집 0~ch-1 까지 배열
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[M];	// 조합하면 생기는 배열 크기 M
		arr = new int[N][N];	// 지도 배열
		
		Queue<int[]> h = new LinkedList<int[]>();	// 집나오면 담을 큐
		Queue<int[]> c = new LinkedList<int[]>();	// 치킨집 나오면 담을 큐
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {	// 집인경우
					h.offer(new int[] {i,j});	// 집큐에 담음
				}else if(arr[i][j]==2) {	// 치킨집인경우
					c.offer(new int[] {i,j});	// 치킨집큐에 담음
				}
			}
		}
		ch = c.size();	// 치킨집의 갯수
		ho = h.size();	// 집의 갯수
		chi = new int[ch][2];	// 치킨집 위치 배열
		hou = new int[ho][2];	// 집 위치 배열
		sub = new int[ho][ch];	// 집마다 치킨집 거리 배열 >> 행은 집, 열은 치킨집
		
		input = new int[ch];	// 치킨집 0~ch-1까지 인덱스로 저장함
		int[] loc = new int[2];
		for (int i = 0; i < ch; i++) {	//치킨집 위치 초기화
			loc = c.poll();	
			chi[i][0] = loc[0];
			chi[i][1] = loc[1];
			input[i] = i;
		}
		for (int i = 0; i < ho; i++) {	// 집위치 초기화
			loc = h.poll();
			hou[i][0] = loc[0];
			hou[i][1] = loc[1];
		}
		
		for (int i = 0; i < ho; i++) {	// 집별로 치킨집거리
			for (int j = 0; j < ch; j++) {
				sub[i][j] = Math.abs(hou[i][0]-chi[j][0]) + Math.abs(hou[i][1]-chi[j][1]);
			}
		}
		min = Integer.MAX_VALUE;
		
		comb(0,0);
		
		System.out.print(min);
	}
	private static void comb(int cnt, int start) {	// 조합
		if(cnt == M) {	// 남는 치킨집 갯수만큼 뽑으면
			int dis=0;	// 현재 치킨거리
			for (int i = 0; i < ho; i++) {	// 집마다 남는 치킨집과의 거리 계산
				int mdis = Integer.MAX_VALUE;	// 현재집과 가장 가까운 치킨집 찾기위함
				for (int j = 0; j < M; j++) {	// 남는 치킨집은 M개
					mdis = mdis < sub[i][number[j]] ? mdis : sub[i][number[j]];
				}
				dis += mdis;	// i번째 집에서 가장 가까운 치킨집 거리 mdis
			}
			min = min < dis ? min : dis; // 기존 치킨거리와 비교하여 더 짧은 거리를 최솟값으로 저장
			return;
		}
		
		for (int i = start; i < ch; i++) {
			number[cnt] = input[i];
			comb(cnt+1,i+1);
		}
	}
	
}
