package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4047_영준이카드카운팅_서형준 {
	static int s, d, h, c;
	static boolean[] sp = new boolean[14];
	static boolean[] di = new boolean[14];
	static boolean[] he = new boolean[14];
	static boolean[] cl = new boolean[14];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("4047.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
here:	for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			s = d = h = c = 13;
			Arrays.fill(sp, true);
			Arrays.fill(di, true);
			Arrays.fill(he, true);
			Arrays.fill(cl, true);
			String[] str = br.readLine().split("");
			for (int i = 0; i < str.length; i += 3) {
				int n = Integer.parseInt(str[i + 1]) * 10 + Integer.parseInt(str[i + 2]);
				switch (str[i]) {
				case "S":
					if (sp[n]) {
						sp[n] = false;
						s--;
					}else {
						sb.append("ERROR").append("\n");
						continue here;
					}
					break;
				case "D":
					if (di[n]) {
						di[n] = false;
						d--;
					}else {
						sb.append("ERROR").append("\n");
						continue here;
					}
					break;
				case "H":
					if (he[n]) {
						he[n] = false;
						h--;
					}else {
						sb.append("ERROR").append("\n");
						continue here;
					}
					break;
				case "C":
					if (cl[n]) {
						cl[n] = false;
						c--;
					}else {
						sb.append("ERROR").append("\n");
						continue here;
					}
					break;

				default:
					break;
				}
			}
			sb.append(s).append(" ").append(d).append(" ").append(h).append(" ").append(c).append("\n");
		}
		System.out.print(sb);
	}

}
