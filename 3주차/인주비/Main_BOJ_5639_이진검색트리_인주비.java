package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_5639_이진검색트리_인주비 {

	/**
	 896ms
	 */
	static int tree[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tree = new int[10001];

		String str = br.readLine();
		int root = Integer.parseInt(str);
		int index = 0;
		tree[index] = root;
		while ((str = br.readLine()) != null) {
			int input = Integer.parseInt(str);
			tree[++index] = input;
		}
		postOrder(0, index);
	} // end of main

	// 왼쪽은 무조건 작고 오른쪽은 무조건 크다
	// 왼쪽트리와 오른쪽트리의 중간을 찾아야 함 -> 자기보다 큰 원소를 만나기 전까지
	public static void postOrder(int current, int lastIndex) {
		// 기저조건은 current가 lastIndex를 넘어버리면?
		if (current > lastIndex)
			return;

		int base = current + 1;
		while (current <= lastIndex && tree[current] > tree[base] && base <= lastIndex)
			base++;

		// 찾았으면 그 앞의 배열, 즉 왼쪽 트리 안에서 또 후위순회
		postOrder(current + 1, base - 1);
		// 남은 오른쪽 안에서 후위순회
		postOrder(base, lastIndex);
		
		System.out.println(tree[current]);
	}
}
