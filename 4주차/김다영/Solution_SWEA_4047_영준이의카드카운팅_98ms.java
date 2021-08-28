package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_4047_영준이의카드카운팅_98ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			String str = br.readLine();
			int[] pattern = {13, 13, 13, 13}; // 4개의 무늬별로 13장 카드가 있음.
			boolean ans = true;
			for(int i = 0; i < str.length(); i += 3) { 
				String a = str.substring(i, i + 3); // 3개씩 자르기 
				char shape = a.charAt(0);
				
				for(int j = i + 3; j < str.length(); j += 3) { // 다음 범위에 같은 카드가 있는지 찾는다. 
					String b = str.substring(j, j + 3); // 3개씩 자르기 
					if(a.equals(b)) { // 같은 카드가 있으면 
						ans = false; // 상태 바꾸기 
						break;
					}
				}
				
				// 겹치는 카드가 없으면 해당하는 무늬 count -1 
				if(shape == 'S') 
					pattern[0]--;
				else if(shape == 'D')
					pattern[1]--;
				else if(shape == 'H')
					pattern[2]--;
				else if(shape == 'C')
					pattern[3]--;
			}
			
			if(ans) {
				for(int i = 0; i < 4; i++) {
					sb.append(pattern[i]).append(" ");
				}
			}else {
				sb.append("ERROR");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
