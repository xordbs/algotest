package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_15686_치킨배달_224ms {
	static int N, M;
	static ArrayList<int[]> home, chicken;
	static boolean[] checked;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		home = new ArrayList<int[]>();
		chicken = new ArrayList<int[]>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				switch(Integer.parseInt(st.nextToken())) {
					case 1: // 집
						home.add(new int[] {i, j});
						break;
					case 2: // 치킨집
						chicken.add(new int[] {i, j});
						break;
				}
			}
		}
		checked = new boolean[chicken.size()];
		combi(0, 0);
		System.out.println(ans);
	}
	
	public static void combi(int idx, int cnt) {
		if(cnt == M) {
			int dist = 0;
			
			for (int i = 0; i < home.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (checked[j])
                        min = Math.min(min, Math.abs(home.get(i)[0] - chicken.get(j)[0]) + Math.abs(home.get(i)[1] - chicken.get(j)[1])); // 선택한 치킨집과 집과의 거리 중 최소값
                }
                dist += min; // 최소 거리 누적 
            }
            ans = Math.min(ans, dist); // 최단거리 -> 도시의 치킨거리
            return;
        }
		
        for (int i = idx; i < chicken.size(); i++) {
        	checked[i] = true;
            combi(i + 1, cnt + 1);
            checked[i] = false;
        }
	}
}
