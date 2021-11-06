package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴_서형준 {		// 128ms 76ms
	static char[][] chr;	//	톱니바퀴 배열
	static char[][] cog;	// 12시 좌 우  톱니 상황 배열
	static int[][] arr;		// cog에 들어가는 톱니바퀴의 인덱스 배열
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		chr = new char[5][8];	// 1~4까지 톱니바퀴
		for (int i = 1; i <= 4; i++) {			
			chr[i] = br.readLine().toCharArray();
		}
		cog = new char[5][3];	
		arr = new int[5][3];
		for (int i = 1; i <= 4; i++) {
			cog[i][0] = chr[i][0];	// 12시 초기화
			cog[i][1] = chr[i][6];	// 좌 
			cog[i][2] = chr[i][2];	// 우
			arr[i][0] = 0;	// cog에 들어간 톱니바퀴의 인덱스 저장
			arr[i][1] = 6;
			arr[i][2] = 2;
		}
		
		int n = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < n; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			int num = Integer.parseInt(st.nextToken());		//  해당 톱니바퀴
			int way = Integer.parseInt(st.nextToken());		
			if(way==1) {	// 1이면 시계방향
				turn(num,num);
			}else {		// 반시계방향
				rturn(num,num);
			}
		}
		int sum = 0;	
		if(cog[1][0] == '1') sum += 1;
		if(cog[2][0] == '1') sum += 2;
		if(cog[3][0] == '1') sum += 4;
		if(cog[4][0] == '1') sum += 8;
		
		System.out.print(sum);
	}
	// 반시계방향 옆은 시계방향으로만 돌아가고, 시계방향 옆은 반시계로만 돌아감
	private static void rturn(int num, int start) {	// 현재 톱니바퀴, 시작 톱니바퀴
		if(num==start) {	// 현재가 시작 톱니라면
			if(num==1) {	// 1일때 우측만 돌릴수있음
				if(cog[1][2] != cog[2][1]) turn(2,start);	// 현재 우톱니 와 우측 좌톱니 가  달라야 돌아감 
			}else if(num==4) {	// 4일때 좌측만 돌릴수있음
				if(cog[4][1] != cog[3][2]) turn(3,start);	// 현재 좌톱니 와 좌측 우톱니 가  달라야 돌아감
			}else {
				if(cog[num][1] != cog[num-1][2]) turn(num-1,start);
				if(cog[num][2] != cog[num+1][1]) turn(num+1,start);
			}
		}else if(num<start){	// 시작톱니의 좌측이라면 좌측만 돌려야함
			if(num!=1 && cog[num][1] != cog[num-1][2]) {	// 현재 좌톱니 와 좌측 우톱니 가  달라야 돌아감
				turn(num-1,start);
			}
		}else {	// 시작톱니의 우측이라면 우측만 돌려야함
			if(num!=4 && cog[num][2] != cog[num+1][1]) {	// 현재 우톱니 와 우측 좌톱니 가  달라야 돌아감
				turn(num+1,start);
			}
		}
		
		for (int i = 0; i < 3; i++) {	
			if(arr[num][i]==7) arr[num][i] = 0;	// 반시계는 인덱스가 증가
			else arr[num][i]++;
		}
		
		
		for (int i = 0; i < 3; i++) {
			cog[num][i] = chr[num][arr[num][i]];	// 바뀐 인덱스대로 톱니를 바꿔야함
		}
		
	}

	private static void turn(int num, int start) {
		if(num==start) {	// 시작점
			if(num==1) {
				if(cog[1][2] != cog[2][1]) rturn(2,start);
			}else if(num==4) {
				if(cog[4][1] != cog[3][2]) rturn(3,start);
			}else {
				if(cog[num][1] != cog[num-1][2]) rturn(num-1,start);
				if(cog[num][2] != cog[num+1][1]) rturn(num+1,start);
			}
		}else if(num<start){	// 좌로 진행중
			if(num!=1 && cog[num][1] != cog[num-1][2]) {
				rturn(num-1,start);
			}
		}else {	// 우로 진행중
			if(num!=4 && cog[num][2] != cog[num+1][1]) {
				rturn(num+1,start);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if(arr[num][i]==0) arr[num][i] = 7;	// 시계는 인덱스가 감소
			else arr[num][i]--;
		}
		
		for (int i = 0; i < 3; i++) {
			cog[num][i] = chr[num][arr[num][i]];
		}
		
	}

}
