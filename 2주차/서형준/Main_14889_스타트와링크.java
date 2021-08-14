package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {	// 332ms
	static int N;
	static int n;
	static int[][] arr;
	static int[] input;
	static int[] numbers;
	static int[] numbers2 = new int[2];
	static int[] arr2;
	static int sum=0;
	static int sum2=0;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		n=N/2;
		arr = new int[N][N];		// 본배열
		arr2 = new int[n];			
		input = new int[N];			// 초기 함수 1~N 
		numbers = new int[n];		// 초기 조합
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			input[i]=i;
		}
		
		for(int i=0; i<N-1; i++) {
			for (int j = i+1; j < N; j++) {
				arr[i][j] += arr[j][i];
			}
		}
		
		
		comb(0,0,n,numbers,input);
		System.out.println(min);
	}
	
	public static void comb(int cnt, int start, int fin, int[] num, int[] inp) {
		if(N==4) {
			int a=Math.abs(arr[0][1]-arr[2][3]);
			int b=Math.abs(arr[0][2]-arr[1][3]);
			int c=Math.abs(arr[0][3]-arr[1][2]);
			
			min = Math.min(a, b);
			min = Math.min(c, min);
			return;
		}
		if(cnt==fin && fin==2) {	// 세부
			sum+=arr[num[0]][num[1]];
			return;
		}else if(cnt==fin) {	// 처음 

			int[] num2 = new int[fin];
			comb(0,0,2,numbers2, num);
			sum2=sum;
			sum=0;
			int p=0;
			int q=0;
			for(int i=0; i<inp.length; i++) {
				if(p<fin && i==num[p]) {
					p++;
				}else {
					num2[q++]=i;
				}
			}
			comb(0,0,2,numbers2, num2);
			min = min > Math.abs(sum-sum2) ? Math.abs(sum-sum2) : min;
			sum=0;
			sum2=0;
			return;
		}
		for(int i=start; i<inp.length; i++) {
			num[cnt]=inp[i];
			comb(cnt+1, i+1, fin, num, inp);
		}
	}
}
