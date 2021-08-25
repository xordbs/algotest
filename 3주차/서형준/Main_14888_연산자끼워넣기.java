package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {	// 620ms
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	static int ans;	// 처음은 고정
	static int N;	// N개의 수
	static int[] opr;	// 연산자 배열
	static int[] arr;	// 숫자 배열
	static boolean[] check;	// 순열시 사용되는 부호배열
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 숫자 갯수 입력받음
		arr = new int[N];			// 생성
		check = new boolean[N];		// 생성 및 초기화
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {	// 초기화
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		opr = new int[N-1];		// 연산자배열 (연산자는 항상 숫자갯수보다 1작음)
		st = new StringTokenizer(br.readLine()," ");
		int cnt=0;
		for (int i = 1; i <= 4; i++) {	// 연산자 1,2,3,4로 구분
			int check = Integer.parseInt(st.nextToken());	// 해당 연산자 갯수
			for(int j=0; j<check; j++) {	// 해당 연산자 갯수만큼 opr 배열에 넣어주기 1,2,3,4가 갯수만큼 들어감
				opr[cnt++] = i;
			}
		}
		ans = arr[0];	// 처음은 고정
		
		int[] answer = new int[N-1];	// 연산자 배열 순열에 쓰임
		perm(answer, 0, N-1);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void perm(int[] answer, int depth, int n) {
		if(depth == n) {		// 연산자 배열이 정렬되면
			int sub = arr[0];	// 값은 무조건 arr[0]부터 시작
			for(int i=0; i<n; i++) {	
				if(answer[i]==1) {	// 연산자 +
					sub += arr[i+1];
				}else if(answer[i]==2) {	// 연산자 -
					sub -= arr[i+1];
				}else if(answer[i]==3) {	// 연산자 *
					sub *= arr[i+1];	
				}else if(answer[i]==4) {	// 연산자 /
					sub /= arr[i+1];
				}
			}
			if(sub>max) max = sub;
			if(sub<min) min = sub;
			return;
		}
		
		for(int i=0; i<n; i++) {
			if (!check[i]) {
                check[i] = true;                    // 중복 체크
                answer[depth] = opr[i];		
                perm(answer, depth+1, n);
                check[i] = false;
            }
		}
	}

}
