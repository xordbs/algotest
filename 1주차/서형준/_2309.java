package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2309 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int[] arr = new int[9];
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			ans += arr[i];
		}
		int dif = ans-100;	// 난쟁이 키 100이니까 가짜 두명 합한 키를 찾으면됨
as:		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]+arr[j] == dif) {		// 9개중 2개만 0으로 만들면 나머진 다 100
					arr[i] = 0;					// 정답 여러가지 경우에 아무거나 출력하래서 상관x
					arr[j] = 0;
					break as;
				}
			}
		}
		Arrays.sort(arr);		// 오름차순 정렬
		
		for(int i=2; i<arr.length; i++) {		//  앞인덱스 2개는 0이므로 출력할필요 없음
			sb.append(arr[i]).append("\n");
		}
		System.out.print(sb);
	}
}
