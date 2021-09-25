package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1347_미로만들기_서형준 {	// 128ms
	static int N,rc;	// 입력길이, row/col배열 인덱스
	static String[][] map;	// 미로
	static int[] row;	// 입력된 행 배열
	static int[] col;	// 입력된 열 배열
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new String[N*2 + 1][N*2 + 1];
		row = new int[N+1];	// 스타트하는곳이 포함되기 때문에 +1 해준다
		col = new int[N+1];
		String[] str = br.readLine().split("");

		find(str);
		int minR=Integer.MAX_VALUE;	
		int maxR=Integer.MIN_VALUE;
		int minC=Integer.MAX_VALUE;
		int maxC=Integer.MIN_VALUE;
		for (int i = 0; i < rc; i++) { // 직사각형 네개의 꼭짓점을 구하기 위함 (minR,minC) (minR,maxC) (maxR,minC) (maxR.maxC)
			minR = minR > row[i] ? row[i] : minR;
			maxR = maxR < row[i] ? row[i] : maxR;
			minC = minC > col[i] ? col[i] : minC;
			maxC = maxC < col[i] ? col[i] : maxC; 
		}
		for (int i = minR; i <= maxR; i++) {	// 직사각형을 돌며 출력
			for (int j = minC; j <= maxC; j++) {
				if(map[i][j]==null) sb.append("#");
				else sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void find(String[] str) {
		int sr = N;	// 처음 시작점
		int sc = N;
		map[sr][sc] = ".";	// . 입력
		row[0]=sr;	// 입력된 행과 열 저장
		col[0]=sr;
		int[] dr = {-1,0,1,0};	//상우하좌 시계방향
		int[] dc = {0,1,0,-1};
		int ch = 2;	// 처음엔 남족을 보고있음
		rc = 1;
		for (int i = 0; i < N; i++) {
			switch (str[i]) {
			case "R":	// 우로 회전
				if(ch==3) ch=0;	
				else ch++;
				break;
			case "L":	// 좌로 회전
				if(ch==0) ch=3;
				else ch--;
				break;
			case "F":	// 전진
				sr += dr[ch];
				sc += dc[ch];
				map[sr][sc]=".";
				row[rc]=sr;
				col[rc]=sc;
				rc++;	// 입력해주고 rc 증가
				break;
			}
		}
	}
}
