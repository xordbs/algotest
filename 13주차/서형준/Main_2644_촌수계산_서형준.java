package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2644_촌수계산_서형준 {	// 132ms 76ms
	public static void main(String[] args) throws Exception{	// 아빠(뿌리)가 같은지만 확인하면 된다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int num = Integer.parseInt(br.readLine());		// 사람수 num
		int[] arr = new int[num+1];	// 인덱스가 아들, 인덱스에 들어가는 값이 아빠
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());	//a와 b의 촌수 계산
		int b = Integer.parseInt(st.nextToken());
		int[] ar = new int[num+1];	// a의 아버지 할아버지....배열

		int m = Integer.parseInt(br.readLine());	// m개의 관계
		for (int i = 0; i < m; i++) {	
			st = new StringTokenizer(br.readLine()," ");
			int p = Integer.parseInt(st.nextToken());	// p가 아빠
			int q = Integer.parseInt(st.nextToken());	// q가 아들
			arr[q] = p;	// q의 아빠는 p
		}
		int cnt = 0;	// 현재 촌수
		int now= a;	// a부터 시작
		while(true) {
			
			ar[now] = cnt;	// now와 a와의 촌수
			if(arr[now]==0) break;	// now의 아빠가 없으면 break
			now = arr[now];	// now는 now 아빠로 변경
			cnt++;	// 촌수 증가
		}
		cnt = 0;	//현재 촌수
		now = b;	// b 부터시작
		while(true) {
			if(ar[now]!=0) {	// a의 조상중에 now가 있다면
				System.out.print(ar[now]+cnt);	// a와now의 촌수 + b와 now의 촌수
				break;
			}else if(now==a) {	// now가 a라면
				System.out.print(cnt);	// b와 a의촌수
				break;
			}else if(arr[now]==0) {	// b의조상이 끝날때까지 a의 조상과 겹치는게 없다면
				System.out.print(-1);
				break;
			}else {	// 조상을 타고올라가는중
				cnt++;	
				now = arr[now];
			}
		}
		
	}

}
