package 서울_9반_서형준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_지하철 {
	static int[] arr,number;
	static boolean[] bool;
	static int N;
	static int max;
	public static void main(String[] args) throws Exception{	// 조합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			number = new int[4];
			bool = new boolean[N];
			max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			find(0,0);	// 조합
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		
		System.out.print(sb);
	}
	private static void find(int cnt,int start) {	
		if(cnt ==4) {	// 01 23, 02 13, 30 12 (인덱스 번호를 기준으로 직통라인 건설할수 있는법 총 3가지)
						// 그 중 2가지 경우만 건설가능 (02 13을 건설할경우 라인이 교차)
			int a = (arr[number[0]]+arr[number[1]]) *  (arr[number[0]]+arr[number[1]]) +  (arr[number[2]]+arr[number[3]]) *  (arr[number[2]]+arr[number[3]]);	// 01 23
			int b = (arr[number[0]]+arr[number[3]]) *  (arr[number[0]]+arr[number[3]]) +  (arr[number[2]]+arr[number[1]]) *  (arr[number[2]]+arr[number[1]]);	// 03 12
			max = max > a ? max : a;
			max = max > b ? max : b;
			return;
		}
		
		for (int i = start; i < N; i++) {
			if(i>0 && !bool[i-1]) {	// 증가하며 뽑기때문에 앞에만 확인하면됨 뒤는 뒤가 알아서 앞을 확인함
				if(i==N-1 && bool[0]) continue;	// 마지막 수일때 0인덱스가 안뽑혀있어야함 이웃하기때문
				bool[i] = true;	// 뽑았다고 처리
				number[cnt] = i;	// 넘버배열에 대입
				find(cnt+1,i+1);	// 다음수 뽑으러 감
				bool[i] = false;	// 돌아오며 복구
			}else if(i==0) {	// 앞자리 확인안돼서 넣어줌
				bool[i] = true;
				number[cnt] = i;
				find(cnt+1,i+1);
				bool[i] = false;
			}
		}
	}

}
