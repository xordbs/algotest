package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1986_체스_서형준 {
	static int[][] Qr,Kr,Pr;
	static int qn,kn,pn,n,m;
	static boolean[][] arr;
	static boolean[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new boolean[n+1][m+1];
		map = new boolean[n+1][m+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		qn = Integer.parseInt(st.nextToken());
		Qr = new int[qn][2];
		for (int i = 0; i < qn; i++) {
			Qr[i][0] = Integer.parseInt(st.nextToken());
			Qr[i][1] = Integer.parseInt(st.nextToken());
			map[Qr[i][0]][Qr[i][1]] = true;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		kn = Integer.parseInt(st.nextToken());
		Kr = new int[kn][2];
		for (int i = 0; i < kn; i++) {
			Kr[i][0] = Integer.parseInt(st.nextToken());
			Kr[i][1] = Integer.parseInt(st.nextToken());
			map[Kr[i][0]][Kr[i][1]] = true;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		pn = Integer.parseInt(st.nextToken());
		Pr = new int[pn][2];
		for (int i = 0; i < pn; i++) {
			Pr[i][0] = Integer.parseInt(st.nextToken());
			Pr[i][1] = Integer.parseInt(st.nextToken());
			map[Pr[i][0]][Pr[i][1]] = true;
		}
		
		for (int i = 0; i < qn; i++) {
			Q(Qr[i][0],Qr[i][1]);
		}
		
		for (int i = 0; i < kn; i++) {
			K(Kr[i][0],Kr[i][1]);
		}
		
		
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(!map[i][j] && !arr[i][j]) cnt++;
			}
		}
		System.out.print(cnt);
	}

	private static void K(int sr, int sc) {
		if(sr+1 < n ) {
			arr[sr+2][sc+1]=true;
			arr[sr+2][sc-1]=true;	
		}
		if(sr-1 > 1 ) {
			arr[sr-2][sc+1]=true;
			arr[sr-2][sc-1]=true;	
		}
		if(sc+1 < m ) {
			arr[sr+1][sc+2]=true;
			arr[sr-1][sc+2]=true;	
		}
		if(sc-1 > 1) {
			arr[sr+1][sc-2]=true;
			arr[sr-1][sc-2]=true;	
		}
	}

	private static void Q(int sr, int sc) {

		for (int i = sr-1; i >= 1; i--) {	// 상
			if(map[i][sc]) break;
			arr[i][sc] = true;
		}
		for (int i = sr+1; i <= n; i++) {	// 하
			if(map[i][sc]) break;
			arr[i][sc] = true;
		}
		for (int i = sc-1; i >= 1; i--) {	// 좌
			if(map[sr][i]) break;
			arr[sr][i] = true;
		}
		for (int i = sc+1; i <= m; i++) {	// 우
			if(map[sr][i]) break;
			arr[sr][i] = true;
		}
		
		int r=sr-1;
		int c=sc+1;
		while(r>=1 && c<=m) {
			if(map[r][c]) break;
			arr[r--][c++] = true;
		}
		r=sr+1;
		c=sc+1;
		while(r<=n && c<=m) {
			if(map[r][c]) break;
			arr[r++][c++] = true;
		}
		r=sr+1;
		c=sc-1;
		while(r<=n && c>=1) {
			if(map[r][c]) break;
			arr[r++][c--] = true;
		}
		r=sr-1;
		c=sc-1;
		while(r>=1 && c>=1) {
			if(map[r][c]) break;
			arr[r--][c--] = true;
		}
	}

}
