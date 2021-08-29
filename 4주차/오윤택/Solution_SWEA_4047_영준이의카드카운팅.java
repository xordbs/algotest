package IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_4047_영준이의카드카운팅 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			String str = br.readLine();
			int[] S = new int[14]; // 초기배열 생성
			int[] D = new int[14];
			int[] H = new int[14];
			int[] C = new int[14];
			
			int scnt = 13; // 카운팅 13으로 시작
			int dcnt = 13;
			int hcnt = 13;
			int ccnt = 13;
			int flag = 0;
			for (int j = 0; j < str.length(); j+=3) { // 3 문자씩 끊어서 증가
				String temp = str.substring(j,j+3);
				int num = Integer.parseInt(temp.substring(1, 3)); // 숫자만 확인
				if(temp.substring(0,1).equals("S")) { // 첫자리 비교
					S[num]++;
					scnt--;
				}else if(temp.substring(0,1).equals("H")) {
					H[num]++;
					hcnt--;
				}else if(temp.substring(0,1).equals("D")) {
					D[num]++;
					dcnt--;
				}else if(temp.substring(0,1).equals("C")) {
					C[num]++;
					ccnt--;
				}
				if(S[num]  >= 2 || H[num] >= 2|| D[num] >= 2|| C[num] >= 2) { // 이미 선택된 자리의 카드면 flag 1로 변경 후 종료
					flag = 1;
					break;
				}
			}
			if(flag == 0) {
				System.out.println("#" + i + " " + scnt + " " + dcnt + " " + hcnt + " " + ccnt);
			}else {
				System.out.println("#" + i + " " + "ERROR");
			}
		}
	}
}
