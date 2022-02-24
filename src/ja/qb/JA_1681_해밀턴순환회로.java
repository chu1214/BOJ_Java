package ja.qb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JA_1681_해밀턴순환회로 {

	static int N;
	static int[][] graph;
	static int ans = Integer.MAX_VALUE;
	
	public static void find(int cur, int cost, int visited, int cnt) {		
		
		if(cost > ans) return;
		
		for(int i = 1; i <= N; i++) {
			if((visited & (1 << (i - 1))) == 0 && graph[cur][i] != 0) {
				find(i, cost + graph[cur][i], visited | (1 << (i - 1)), cnt + 1);
			}
		}
		
		if(cnt == N - 1) {
			if(graph[cur][1] == 0) return;
			cost += graph[cur][1];
			if(cost < ans) ans = cost;
			return;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		graph = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(1, 0, 1, 0);
		
		System.out.println(ans);
	} 
}