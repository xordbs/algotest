package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815_숫자카드 {	// 1540ms
	static int[] arr;
	static int N;
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];	//  숫자카드 배열
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);	// 숫자카드 정렬
		
		int M = Integer.parseInt(br.readLine());	// 상근이 숫자 갯수
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < M; i++) {		// 상근이 배열
			find(Integer.parseInt(st.nextToken()));
		}
		System.out.print(sb);
	}
	
	public static void find(int n) {	// n이 숫자 카드에 있나 확인, 반씩 나눠서 접근
		int i=N/2;		// 가운데부터 확인 
		int[] arr2 = new int[] {0,N-1};
		if(n<arr[0] || n > arr[N-1]) {	// n이 0보다 작거나  마지막 수보다 클경우 없는거임
			sb.append(0).append(" ");	// 0 추가
		}else if(n == arr[0] || n == arr[N-1]) {	// 0이나 마지막수랑 같다면
			sb.append(1).append(" ");	// 1추가
		}else {
			while(true) {		// 반씩 쪼개기 시작
				if(((i-1)>=0 && (i+1) < N) && (n==arr[i] || n==arr[i-1] || n==arr[i+1])) {	// 반쪼갰을때  범위 벗어나면 안되고, 해당값이랑 양옆 조사하고 있으면 1추가
					sb.append(1).append(" ");
					break;
				}else if(n > arr[i] && n < arr[i+1]) {	// 해당값이 현재값보다 큰데, 다음배열 값보다 작으면 값이 없는거
					sb.append(0).append(" ");
					break;
				}else if(n < arr[i]) {	// 해당값이 현재 값보다 작을때
					arr2[1]=i;		// 마지막값 현재 인덱스로 초기화
					i=(i+arr2[0])/2;	// 반쪼갬
				}else if(n > arr[i]) {	// 해당값이 현재값보다 클때
					arr2[0]=i;		// 시작값 현재인덱스로 초기화
					i=(i+arr2[1])/2;// 반쪼갬
				}
			}
		}
	}
}
