package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2310_어드벤처게임_서형준 {

	static int[][] room;
	static boolean[][] check2;
	static int num;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			num = Integer.parseInt(br.readLine());
			if(num==0) break;
			room = new int[num+1][num+1];
			check2 = new boolean[num+1][num+1];
			for (int i = 1; i <= num; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				String type = st.nextToken();
				if(type.equals("E")) {
					room[i][0] = Integer.parseInt(st.nextToken());
					int ch=1;
					while(true) {
						room[i][ch] = Integer.parseInt(st.nextToken());
						if(room[i][ch++] == 0) break;
					}
				}else if(type.equals("T")) {
					room[i][0] = Integer.parseInt(st.nextToken())*(-1);
					int ch=1;
					while(true) {
						room[i][ch] = Integer.parseInt(st.nextToken());
						if(room[i][ch++] == 0) break;
					}
				}else {
					int ch=0;
					while(true) {
						room[i][ch] = Integer.parseInt(st.nextToken());
						if(room[i][ch++] == 0) break;
					}
				}
			} // 배열 완성
			
			int c=1;
			boolean check = false;
			while(true) {
				if(room[1][c] == 0 ) break;
				check2[1][c] = true;
				if(find(room[1][c],0)) {
					check = true;
					break;
				}
				check2[1][c] = false;
				c++;
			}
			
			if(check) {
				sb.append("YES").append("\n");
			}else {
				sb.append("NO").append("\n");
			}
		}// 미로 반복 끝
		System.out.print(sb);
		
	}
	private static boolean find(int rNum, int coin) { // 방번호, 코인갯수
		if(room[rNum][0]>0 && coin<room[rNum][0]) {
			coin = room[rNum][0];
		}else if(room[rNum][0]<=0){
			coin = coin + room[rNum][0];
		}
		if(coin<0) return false;
		if(rNum==num) return true;
		int i=1;
		boolean check = false;
		while(true) {
			if(room[rNum][i]==0) break;
			if(room[rNum][i]==rNum) {
				i++;
				continue;
			}
			if(!check2[rNum][i]) {
				check2[rNum][i] = true;
				if(find(room[rNum][i], coin)) {
					check = true;
					break;
				}
				check2[rNum][i] = false;
			}

			i++;
		}
		
		if(check) {
			return true;
		}else {
			return false;
		}
	}

}
