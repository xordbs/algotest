package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2606_바이러스_76ms {
	static List<Integer>[] list;
	static boolean[] chked; 
	static int cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		chked = new boolean[num+1];
		list = new ArrayList[num+1];
		for (int i = 0; i < num+1; i++) {
			list[i] = new ArrayList<>(); // 리스트 초기화
		}
		int link = Integer.parseInt(br.readLine());
		for (int i = 0; i < link; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			list[a].add(b); // 연결되어있는 숫자에 각자 한번씩 추가
			list[b].add(a);
		}
		chked[1] = true; // 1번 컴퓨터는 감염 되어있으니까 무조건 true
		search(1); // 1을 넣어서 1에 연결되어있는것 부터 찾음
		System.out.println(cnt);
	}

	private static void search(int index) {
			int current = index;
			for (int i = 0; i <list[current].size(); i++) { // index로 들어온 번호에 연결되어있는 리스트 확인
				if(!chked[list[current].get(i)]) { // 번호에 해당하는 chked가 false면 true로 바꿔주고 cnt++
					chked[list[current].get(i)] = true;
					cnt++;
					search(list[current].get(i)); // 반복
				}
			}
				
	}
	
	
}
