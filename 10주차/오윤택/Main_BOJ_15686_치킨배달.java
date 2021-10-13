package BOJ;

import java.io.*;
import java.util.*;

/*
 * 160ms
 * 완탐 
 */
public class Main_BOJ_15686_치킨배달 {
	
	static int N, M, result = Integer.MAX_VALUE;
	static ArrayList<int[]> house, chicken;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(str.nextToken()); // 도시크기 
		M = Integer.parseInt(str.nextToken()); // 살릴 치킨집 개수
		house = new ArrayList<int[]>(); 
		chicken = new ArrayList<int[]>(); 
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(str.nextToken());
				if(num == 1) {
					house.add(new int[] {i,j});
				}else if(num == 2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		visited = new boolean[chicken.size()];
		comb(0,0);
		System.out.println(result);
	}

	private static void comb(int start, int cnt) {
		if(cnt == M) {
			int temp = 0;
			for (int i = 0; i < house.size(); i++) {
				int dept = Integer.MAX_VALUE;
				for (int j = 0; j < visited.length; j++) {
					if(visited[j]) {
						int value = Math.abs(house.get(i)[0] - chicken.get(j)[0]) + Math.abs(house.get(i)[1] - chicken.get(j)[1]); 
						dept = Math.min(dept, value);
					}
				}
				temp += dept;
			}
			result = Math.min(temp, result);
			return;
		}
		
		for (int i = start; i < visited.length; i++) {
			visited[i] = true;
			comb(i+1, cnt+1);
			visited[i] = false;
		}
	}
}
