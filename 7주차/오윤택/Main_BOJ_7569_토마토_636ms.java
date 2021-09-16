package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7569_토마토_636ms {
	
	static int[] dr = {-1, 1, 0, 0, 0, 0}; // 상하좌우 z상z하
	static int[] dc = { 0, 0,-1, 1, 0, 0};
	static int[] dz = { 0, 0, 0, 0,-1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(str.nextToken());
		int n = Integer.parseInt(str.nextToken());
		int h = Integer.parseInt(str.nextToken());
		int[][][] map = new int[n][m][h];
		
		Queue<int[]> q = new  LinkedList<>();
		int zero = 0;
		int cnt = 0;
		for (int z = 0; z < h; z++) {
			for (int i = 0; i < n; i++) {
				str = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < m; j++) {
					int num = Integer.parseInt(str.nextToken());
					map[i][j][z] = num;
					
					if(map[i][j][z] == 1 ) {
						q.add(new int[] {i,j,z});
					}else if(map[i][j][z] == 0) {
						zero++;
					}
				}
			}
		} // 1이면 큐에 배열 삽입, 0이면 zero++
		
		while(zero > 0 && !q.isEmpty()){ //큐가 비어있지 않고 0의 갯수가 양수면 반복
			int size = q.size();
			for (int i = 0; i < size ; i++) { // 큐의 사이즈 만큼 반복(하루당 익어있는 토마토의 갯수)
				int[] arr = q.poll();
				
				for (int j = 0; j < 6; j++) {
					int  nr = arr[0]+ dr[j];
					int  nc = arr[1]+ dc[j];
					int  nz = arr[2]+ dz[j];
					
					if(nr < 0 || nc < 0 || nz < 0 || nr >= n || nc >= m || nz >= h || map[nr][nc][nz] != 0) { // 배열범위에서 벗어나거나 0이 아니면 다음으로
						continue;
					}
					zero--; // 익지않은 토마토 갯수 차감
					map[nr][nc][nz] = 1; // 익은토마토로 만들고
					q.add(new int[] {nr,nc,nz}); // 큐에 익은토마토 위치 삽입
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
