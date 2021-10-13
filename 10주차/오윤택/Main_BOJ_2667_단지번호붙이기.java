package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_2667_단지번호붙이기 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dr = {-1,1,0,0}; // 상하좌우
		int[] dc = {0,0,-1,1};
		
		
			int N = Integer.parseInt(br.readLine());

			char[][] map = new char[N][N];
			boolean[][] visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			
			Queue<int[]> q = new LinkedList<>();
			ArrayList<Integer> list = new ArrayList<>();
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '1' && !visited[i][j]) {
						q.add(new int[] { i, j });
						cnt++;
						list.add(0);
						
						while(!q.isEmpty()) {
							int size = q.size();
							for (int k = 0; k < size; k++) {
								int arr[] = q.poll();
								for (int d = 0; d < 4; d++) {
									
									int nr = arr[0] + dr[d];
									int nc = arr[1] + dc[d];
									
									if(nr < 0 || nc < 0 || nr >= N || nc >= N ) continue; // 범위 밖 체크
									if(visited[nr][nc] || map[nr][nc] == '0') continue; // 이미 방문 또는 없는 곳 체크
									
									visited[nr][nc] = true;
									q.add(new int[] {nr, nc});
									list.set(cnt-1, list.get(cnt-1)+1);
								}
							}
						}
						
					}
				}
			}
			System.out.println(list.size());
			list.sort(Comparator.naturalOrder());
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i) == 0) {
					System.out.println(1);
				}else {
					System.out.println(list.get(i));
				}
			}
	}
}
