package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_9095_123더하기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < TC; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(recursive(N)).append("\n");
		}//end of for
		
		System.out.println(sb);
	}//end of main
	
	//recursive(n) = recursive(n-1)+recursive(n-2)+recursive(n-3);
	public static int recursive(int n) {
		
		if (n == 1 || n == 2)
			return n;
		if (n == 3)
			return 4;
		
		return recursive(n-1)+recursive(n-2)+recursive(n-3);
	}
} // end of class
