package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dfs_S2_11724 {

	static int N, M;
	static boolean[][] Network;
	static boolean[] isVisited;
	static int ans = 0;
	
	public static void dfs(int cur) {
		isVisited[cur] = true;
		for(int i = 1; i <= N; i++) {
			if(Network[cur][i] == true && !isVisited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Network = new boolean[N+1][N+1];
		isVisited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			Network[u][v] = true;
			Network[v][u] = true;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!isVisited[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
}