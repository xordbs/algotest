package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_9012_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			Stack<Character> stack = new Stack<>(); 
			
			String str = br.readLine(); 
			boolean ans = true;
			
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if(c == '(') {
					stack.push(c); // 여는 괄호이면 스택에 쌓는다.
				} else {
					if(!stack.empty()) { 
						stack.pop(); // 닫는 괄호이고, 스택이 비어있지 않으면 스택에 쌓아둔 여는 괄호를 꺼낸다. (한 쌍)
					} else { 
						ans = false; // 닫는 괄호인데 스택이 비어있으면 VPS가 아님!
						break;
					}
				}
			}
			
			if(ans == true && stack.isEmpty() == true) { // 들어온 문자열을 다 체크한 후에는 스택이 비어있어야함.
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}
}
