package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_10815_숫자카드_3856ms {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 숫자카드 개수 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; i++) { // 가지고 있는 숫자카드의 숫자 
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // 오름차순 정렬 
		
		M = Integer.parseInt(br.readLine()); // 비교해야할 숫자 카드 개수 
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) { // 비교해야할 숫자 
			int num = Integer.parseInt(st.nextToken());
			if(binarySearch(num)) System.out.print("1 ");
			else System.out.print("0 ");
		}
	}
	
	public static boolean binarySearch(int num) { // 이진탐색 
		int left = 0; // 배열의 왼쪽 끝 index
		int right = N - 1; // 배열의 오른쪽 끝 index
		
		while(left <= right) { 
            int mid = (left + right) / 2; // 중간 index 

            if(num < arr[mid]) right = mid - 1;
            else if(num > arr[mid]) left = mid + 1;
            else return true; // num = arr[mid] -> true 
        }
        return false;
	}
}
