package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_백준_2668_숫자고르기_인주비 {
	/*
	 * 80ms
	 */
	static int N, input[];
	static ArrayList<Integer> answer;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N+1];
		answer = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			if (input[i] == i) answer.add(i);
			else {
				dfs(i, i);
			}
			
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
	
	public static void dfs(int start, int i) {
		
		if (!visited[input[i]]) {
			visited[i] = true;
			dfs(start, input[i]);
			visited[i] = false;
		}
		if (start == input[i]) answer.add(start);
			
	}
}
