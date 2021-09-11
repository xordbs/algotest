package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2210_숫자판점프 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int cnt;
	static String str2;
	static String[][] str;
	static String[] sub;
	public static void main(String[] args) throws Exception{	// 미완성 뭔가 잘못돼서 완성시키고 다시올릴게요
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		sub = new String[1000000];
		str = new String[5][5];
		cnt=0;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 5; j++) {
				str[i][j] = st.nextToken();
			}
		}
		
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 1; j++) {
				str2 = "";
				find(i,j,0);
			}
		}
		for (int i = 0; i <= cnt; i++) {
			System.out.print(sub[i]+" ");
		}
		System.out.print(cnt);
		
	}
	
	public static void find(int sr, int sc, int num) {
		if(num==6) {
			for (int i = 0; i <= cnt; i++) {
				if(sub[i] != null && sub[i].equals(str2)) break;
				if(i==cnt) {
					//System.out.println(cnt);
					cnt++;
					sub[cnt]=str2;
				}
			}
			return;
		}
		str2 += str[sr][sc];

		for (int i = 0; i < 4; i++) {
			if(sr+dr[i]<0 || sr+dr[i]>4 || sc+dc[i] < 0 || sc+dc[i]>4 ) continue;
			find(sr+dr[i], sc+dc[i], num+1);
			str2 = str2.substring(0,num);
			System.out.println(num + " " + str2);
		}
	}
}
