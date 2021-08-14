package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Stack;

public class Main_9012_괄호 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 176ms
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
here:	for (int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split("");
			int cnt=0;
			for(int i=0; i<str.length; i++) {
				if(str[i].equals("(")) cnt++;
				else {
					cnt--;
					if(cnt<0) {
						sb.append("NO").append("\n");
						continue here;
					}
				}
			}
			
			sb.append(cnt==0?"YES" : "NO").append("\n");
		}
		System.out.print(sb);
	}
}

/*		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	152ms
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
here:	for (int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split("");
			Stack<String> stack = new Stack<String>();
			
			for(int i=0; i<str.length; i++) {
				if(str[i].equals("(")) {
					stack.push(str[i]);
				}else if(str[i].equals(")")){
					if(stack.size()!=0 && stack.peek().equals("(")) stack.pop();
					else {
						sb.append("NO").append("\n");
						continue here;
					}
				}
			}
			sb.append(stack.size() == 0 ? "YES" : "NO").append("\n");
		}
		System.out.print(sb);*/