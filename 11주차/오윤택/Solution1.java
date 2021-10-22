import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1 {

	static char[][] map; // 입력을 담을 배열(장기판)
	static boolean[][] chked; //한번이라도 방문한 위치 체크
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static int N, count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			chked = new boolean[N][N];
			int r = 0;
			int c = 0;
			for (int i = 0; i < N; i++) {
				String st = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = st.charAt(j * 2);
					if (map[i][j] == '2') { // 포가 있는 자리 변수에 담기
						r = i;
						c = j;
					}
				}
			}
			count = 0; // 잡을수 있는 갯수를 담을 변수
			dfs(r, c, map, 0); // 포 r,c,기본장기판, 카운트

			System.out.println("#"+tc+" "+count);
		}
	}

	private static void dfs(int a, int b, char[][] map2, int cnt) {
		if(cnt == 3) return; // 3번 모두 이동하면 리턴
		
		char[][] copyMap = copymap(map2); // 기본배열 복사
		copyMap[a][b] = '2'; // 장기말 포가 이동한 위치는 2로 변경
		
		for (int i = 0; i < 4; i++) { // 상하좌우 계산
			boolean flag = false; // a, b를 기준으로 i번쨰(상하좌우) 게산중 첫번쨰 1을 만나면  true 처리(true 이후 부터 이동가능한 위치) 
			int one = 0;
			for (int j = 1; j <= N; j++) { // 2의 위치에서 배열 0~ N 만큼 상하좌우 이동할수 있는 위치 계산
				int nr = a + dr[i] * j;
				int nc = b + dc[i] * j;
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N ) break; // 배열을 벗어나면 중단 continue가 아닌 이유는 이미 벗어나면 다음을 계산하는게 의미가 없기 때문
				if (flag && one < 2) {
					if (copyMap[nr][nc] == '1' && !chked[nr][nc]) { // 복사한 배열의 nr,nc의 값이 1이고 , 한번도 방문하지 않은 위치면 잡을수 있는 장기말이므로  방문체크 후 count++
						chked[nr][nc] = true;
						count++;
						dfs(nr, nc, copyMap, cnt+1); // cnt가 3이 될때까지 반복
					}
					else dfs(nr, nc, copyMap, cnt+1); // nr,nc의 값이 1이 아니면 빈 자리를 나타내므로 위치로 이동후 반복
				}
				if (copyMap[nr][nc] == '1') {
					flag = true;
					one++; // 장기말 포는 2개 이상 뛰어넘지 못하기 때문에 one으로 계산
					continue;
				}
			}
		}
	}

	private static char[][] copymap(char[][] map2) { // 배열 복사
		char[][] copy = new char[N][N];
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2.length; j++) {
				copy[i][j] = map2[i][j];
			}
		}
		return copy;
		
	}
}

//#1 4
//
//#2 15
//
//#3 18
//
//#4 0
//
//#5 102

