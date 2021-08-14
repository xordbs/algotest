package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크_오윤택 {
	
	static int N, min = Integer.MAX_VALUE;
	static int[][] map;
	static int[] TeamA;
	static int[] TeamB;
	static boolean[] chk;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		TeamA = new int[N/2];
		TeamB = new int[N/2];
		chk = new boolean[N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		devsion(0, 0);
		System.out.println(min);
		
	}
	// 팀 나누기
	private static void devsion(int start, int cnt) {
		if(cnt == N/2) {
			int idx1 = 0, idx2 = 0;
			for (int i = 0; i < N; i++) { // boolean 타입으로 팀을 나눔
				if (chk[i]) TeamA[idx1++] = i; //A팀
				else TeamB[idx2++] = i; //B팀
			}
			int result = Math.abs(sum(TeamA, 0, 0)-sum(TeamB, 0, 0));
			min = min > result?result:min;
			return;
		}

		for (int i = start; i < N; i++) {
			chk[i] = true;
			devsion(i+1, cnt+1);
			chk[i] = false;
		}
	}

	
	// 팀별 능력치 계산  
	// 결과적으로 nCn/2 조합의 n/2C2 조합
	private static int sum(int[] select, int S, int cnt) {
		if(cnt == N/2) {
			return S;
		}
        for (int i = 0; i < N / 2; i++) {
            for (int j = i+1; j < N / 2; j++) {
                S += map[select[i]][select[j]] + map[select[j]][select[i]];
            }
        }
		return S;
	}
	
}
