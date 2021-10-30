package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * 76ms
 *
 */

public class Main_BOJ_2661_좋은수열 {
	static String ans;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs("1");
		System.out.println(ans);
	}

	public static boolean dfs(String str) {
		if (str.length() == N) { // 문자열의 길이가 입력 받은 크기 n과 같다면 종료
			ans = str; // 순서가 1,2,3으로 되기 때문에 가장 먼저 자리를 차지하고 온게 가장 작은 수이다.
			return true;
		}
		for (int i = 1; i <= 3; i++) {
			String s = str + String.valueOf(i); // str에 i값을 더해준다. 
			int start = s.length() - 1; // 마지막 직전부터 비교
			int end = s.length(); // 마지막 
			boolean flag = false;
			
			for (int j = 1; j <= s.length() / 2; j++) { // 전체 길이의 절반으로 나누어 비교
				String sub1 = s.substring(start, end);
				String sub2 = s.substring(start - j, start);
				if (sub1.equals(sub2)) { // 비교되는 두 문자가 같다면 flag를 true로 변경후 반복문 종료
					flag = true;
					break;
				}
				start -= 1; // 아니라면 start를 하나 당겨서 다시 비교
			}
			if (!flag) { // flag가 false인 체로 나오게되면 dfs를 반복 dfs 결과가 true이면 true를 리턴
				if (dfs(s)) return true;
			}
		}
		return false;
	}
}
