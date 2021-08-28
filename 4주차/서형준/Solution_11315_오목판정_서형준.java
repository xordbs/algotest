package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_11315_오목판정_서형준 {
	static String[][] str; 
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("11315.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
here:	for (int tc = 1; tc <=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			str = new String[N][N];
			for (int i = 0; i < N; i++) {
				str[i] = br.readLine().split("");
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(str[i][j].equals("o")) {
						if((i+4) < N) {
							for (int k = 1; k < 5; k++) {
								if(str[i+k][j].equals(".")) break;
								if(k==4) {
									sb.append("YES").append("\n");
									continue here;
								}
							}
						}
						if((i+4) < N && (j+4) < N) {
							for (int k = 1; k < 5; k++) {
								if(str[i+k][j+k].equals(".")) break;
								if(k==4) {
									sb.append("YES").append("\n");
									continue here;
								}
							}
						}
						if((j+4) < N) {
							for (int k = 1; k < 5; k++) {
								if(str[i][j+k].equals(".")) break;
								if(k==4) {
									sb.append("YES").append("\n");
									continue here;
								}
							}
						}
						if((i-4)>=0 && (j+4) < N) {
							for (int k = 1; k < 5; k++) {
								if(str[i-k][j+k].equals(".")) break;
								if(k==4) {
									sb.append("YES").append("\n");
									continue here;
								}
							}
						}
					}
				}
			}
			sb.append("NO").append("\n");
		}
		System.out.print(sb);
	}
}
