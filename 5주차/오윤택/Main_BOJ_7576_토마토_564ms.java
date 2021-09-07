package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7576_토마토_564ms {
	
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(str.nextToken());
		int n = Integer.parseInt(str.nextToken());
		int[][] map = new int[n][m];
		
		Queue<int[]> q = new  LinkedList<>();
		int zero = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if(map[i][j] == 1 ) {
					q.add(new int[] {i,j});
				}else if(map[i][j] == 0) {
					zero++;
				}
			}
		} // 1이면 큐에 배열 삽입, 0이면 zero++
		
		while(zero > 0 && !q.isEmpty()){ //큐가 비어있지 않고 0의 갯수가 양수면 반복
			int size = q.size();
			for (int i = 0; i < size ; i++) { // 큐의 사이즈 만큼 반복(하루당 익어있는 토마토의 갯수)
				int[] arr = q.poll();
				
				for (int j = 0; j < 4; j++) {
					int  nr = arr[0]+ dr[j];
					int  nc = arr[1]+ dc[j];
					
					if(nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] != 0) { // 배열범위에서 벗어나거나 0이 아니면 다음으로
						continue;
					}
					zero--; // 익지않은 토마토 갯수 차감
					map[nr][nc] = 1; // 익은토마토로 만들고
					q.add(new int[] {nr,nc}); // 큐에 익은토마토 위치 삽입
				}
			}
			cnt++; // 요일 추가
		}
		if(zero == 0) {
			System.out.println(cnt);
		}else {
			System.out.println(-1);
		}
	}
}
