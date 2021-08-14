package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_9012_괄호_오윤택 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			String str = br.readLine();
			Stack<String> stack = new Stack<String>();
			stack.push("X"); // 닫는 괄호가 먼저들어왔을 경우를 생각해서 X를 스택에 먼저 넣어둔다.
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '(') { // 문자열의 j번째 자리가 (일 경우 스택에 ( 추가
					stack.push("(");
				}else {						//스택이 비어있지 않고 j번째 자리가 (가 아니면 스택에서 (를 빼준다.
					if(!stack.isEmpty()) { // 스택이 비어있다면 정상적인 VPS가 아니므로 종료
						stack.pop();
					}else {
						break;
					}
				}
			}
			if(!stack.isEmpty() && stack.peek() == "X") { // 스택이 비어있지 않고 가장 위의 값이 x이면 
				System.out.println("YES"); // 정상적인 vps이다.
			}else {
				System.out.println("NO");
			}
		}
		
	}
	
}
