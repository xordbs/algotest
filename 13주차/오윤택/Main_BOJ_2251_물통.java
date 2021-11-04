package ssafy_13wk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 
 * 112ms
 * 버킷은 총 3개 한 버킷당 담을수 있는 물의 양은 200 
 * 한번에 하나만 움직인다. 
 * 경우의 수 6가지
 */

public class Main_BOJ_2251_물통 {
	
	static int a, b, c;
	static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		visited = new boolean[a + 1][b + 1][c + 1];

		ArrayList<Integer> ans = new ArrayList<>(); // a가 0일때 c의 양을 저장할 배열
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { 0, 0, c });

		while (!q.isEmpty()) {
			int[] bucket = q.poll();

			// 방문체크
			if (visited[bucket[0]][bucket[1]][bucket[2]]) continue;
			
			visited[bucket[0]][bucket[1]][bucket[2]] = true;

			// a가 0이면 c의 값을 저장
			if (bucket[0] == 0) ans.add(bucket[2]);

			// b-> a
			if (bucket[0] + bucket[1] > a)  q.add(new int[] { a, bucket[0] + bucket[1] - a, bucket[2] }); // a와 b 물의 합이 a버킷의 크기 보다 크면 채우고 나머지 b
			else  q.add(new int[] { bucket[0] + bucket[1], 0, bucket[2] });

			// a- > b
			if (bucket[0] + bucket[1] > b) q.add(new int[] { bucket[0] + bucket[1] - b, b, bucket[2] });
			else q.add(new int[] { 0, bucket[0] + bucket[1], bucket[2] });
			

			// a-> c
			if (bucket[0] + bucket[2] > a) q.add(new int[] { a, bucket[1], bucket[0] + bucket[2] - a });
			else  q.add(new int[] { bucket[0] + bucket[2], bucket[1], 0 });
			

			// c -> a
			if (bucket[0] + bucket[2] > c) q.add(new int[] { bucket[0] + bucket[2] - c, bucket[1], c });
			else q.add(new int[] { 0, bucket[1], bucket[0] + bucket[2] });
			

			// b -> c
			if (bucket[1] + bucket[2] > b) q.add(new int[] { bucket[0], b, bucket[1] + bucket[2] - b });
			else q.add(new int[] { bucket[0], bucket[1] + bucket[2], 0 });
			
			
			// c -> b
			if (bucket[1] + bucket[2] > c) q.add(new int[] { bucket[0], bucket[1] + bucket[2] - c, c });
			else q.add(new int[] { bucket[0], 0, bucket[1] + bucket[2] });
			
		}

		Collections.sort(ans); // 정렬
		for (int i = 0; i < ans.size(); i++)
			System.out.print(ans.get(i) + " ");
	}
}