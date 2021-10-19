package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 80ms
 */
public class Main_BOJ_17471_게리맨더링 { 

	static int N, M, sum, temp,  min = Integer.MAX_VALUE; // 구역수, 1구역 수, 최소값
	static int[] psu; // 구역별 인구수
	static boolean[][] arr; // 구역별 인접 구역
	static boolean[] isSelected; // 구역 부분집합 체크
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 인구수 입력
		psu = new int[N];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) { // 구역별 인구수 저장
			psu[i] = Integer.parseInt(str.nextToken());
		}
		
		// 구역별 인접 구역 체크
		arr = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(str.nextToken());
			for (int j = 0; j < num; j++) {
				int value = Integer.parseInt(str.nextToken()) - 1;
				arr[i][value] = true; // 인접 구역 체크
			}
		}
		
		isSelected = new boolean[N];
		for (int i = 0; i < (N / 2)+1; i++) { // 부분집합 갯수 절반 까지만 생성
			M = i;
			Arrays.fill(isSelected, false);
			generateSubSet(0, 0);
		}
		System.out.println(min == Integer.MAX_VALUE?-1:min);
	}

	// 부분집합 + 순열
	private static void generateSubSet(int start, int cnt) { 
		if(M != 0 && cnt==M) {
			sum = Integer.MAX_VALUE;
			// 구역별 계산
	        visited = new boolean[N];
	        int local1 = 0;
	        for(int i = 0; i < N; i++) {
	            if(isSelected[i] && !visited[i]) {  // 1구역
	            	temp = 0;
	            	calc(i);
	            	local1 = temp;
	                break;
	            }
	        }
	        
	        int local2 = 0;
	        for(int i = 0; i < N; i++) {
	            if(!isSelected[i] && !visited[i]) { // 2구역  
	            	temp = 0;
	            	calc(i);
	            	local2 = temp;
	                break;
	            }
	        }
	        
	        for(int i = 0; i<N; i++) {
	            if(!visited[i]) return; // 모두 방문했는지 체크
	        }
	        sum = Math.abs(local1-local2);
            min = Math.min(min, sum);
            return;
		}
		for (int i = start; i < N; i++) {
			isSelected[i]=true;
			generateSubSet(i+1,cnt+1);
			isSelected[i]=false;
		}

	}
    
    public static void calc(int k) { // 구역별 인구수 계산 k구역 기준
        visited[k] = true;
        temp += psu[k];
        for(int i = 0; i < N; i++) {
            if(!visited[i] && (isSelected[i] == isSelected[k]) && arr[i][k]) { // 방문하지 않았고 같은 구역이고 인접해있는지 체크
            	calc(i); // 맞으면 반복
            }
        }
    }
}
