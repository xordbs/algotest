package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {
	
	static int[][] arr;
	static int N;
	static int max=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		money(1,arr[1][1]);	// 1일차부터 입력이라 0일차 그냥 메모리 낭비해줌
		System.out.print(max);
	}
	
	public static void money(int day, int pay) {	// 일차, 페이 입력
		if(arr[day][0]+day>N+1) {	// 일을 받았을때 끝낼수 없을경우
			for(int i=1; i<N-day+1; i++) {	// 다음일을 받았을때 끝낼수 있나 확인
				money(day+i,pay+arr[day+i][1]-arr[day][1]);
			}
			pay-=arr[day][1];		// 이날 입력받은 페이는 못받는거니까 빼주고 계산
			max = max<pay ? pay : max;
			return;
		}else if(arr[day][0]+day==N+1){	//  일을 받았을때 끝나는날 완료될때
			for(int i=1; i<N-day+1; i++) {	// 다음일을 받았을때 끝낼수 있나 확인	
				money(day+i,pay+arr[day+i][1]-arr[day][1]);
			}
			max = max<pay ? pay : max;
			return;
		}else {
			money(day + arr[day][0], pay+arr[day + arr[day][0]][1]);	// 입력받고 끝나는날 다음날 다시또 일거리 찾기
		}
		
		for(int i=1; i<arr[day][0]; i++) {	// 
			money(day+i,pay+arr[day+i][1]-arr[day][1]);
		}
	}
}

