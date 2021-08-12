package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_9012_괄호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] input = str.toCharArray();
			// 비어있을 때: 무조건 넣기
			// 비어있지 않을 때: peek이 같은지 확인 후 같으면 넣고 아니면 뽑기
			// 다르다는 게 () 이럴때는 뽑는게 맞는데 )( 이럴 경우가 있으니까 체크해 줘야 한다
			for (int j = 0; j < input.length; j++) {
				if (stack.isEmpty()) {
					stack.push(input[j]);
					continue;
				}

				else {
					if (stack.peek().equals(input[j]))
						stack.push(input[j]);
					else if (stack.peek() == '(' && input[j] == ')') {
						stack.pop();
					} else
						stack.push(input[j]);
				}
			}

			if (!stack.isEmpty())
				sb.append("NO");
			else
				sb.append("YES");
			sb.append("\n");
			stack.clear();
		} // end of for
		System.out.println(sb);
	} // end of main
} // end of class
