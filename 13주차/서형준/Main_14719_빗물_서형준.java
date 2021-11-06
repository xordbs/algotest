package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물_서형준 {	// 140ms 92ms

	public static void main(String[] args) throws Exception{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int r = Integer.parseInt(st.nextToken());	// 맵의 행
		int c = Integer.parseInt(st.nextToken());	// 맵의 열
		boolean[][] map = new boolean[r][c];	// 맵의 행렬
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < c; i++) {
			int s = Integer.parseInt(st.nextToken());	
			for (int j = 1; j <= s; j++) {	// 입력된수만큼 해당열 마지막행부터 벽돌쌓기
				map[r-j][i] = true;
			}
		}
		
		int sum = 0;	// 현재 빗물 고인 칸수
		for (int i = r-1; i >=0; i--) {	// 마지막행부터 올라오면서 탐색
			boolean check = false;	// 벽돌만나야 빗물이 고일수있음
			int cnt=0;	// 빗물 잠시 저장
			for (int j = 0; j < c; j++) {	// 해당 행의 처음부터 마지막 열까지 탐색
				if(map[i][j]) {		// 벽돌이 있다면
					if(check) {		// 이미 빗물을 모으고있었을경우
						if(cnt==0) {	// 아직 모은게 없다 -> 연속된벽
							check=true; 
						}else {		// 모은게 있다 -> 거기까지 고일수있다
							sum += cnt;	// cnt만큼 모은거 더해주고 초기화
							cnt=0;
						}
					}else {		// 빗물을 모으지 못했다면 처음만난 벽이니까 지금부터 모을수있음
						check = true;
					}
				}else {			// 벽돌이 없다면
					if(check) {	// 빗물을 모으고 있었다면 계속 모아준다
						cnt++;	
					}
				}
			}
		}
		System.out.print(sum);
		
	}

}
