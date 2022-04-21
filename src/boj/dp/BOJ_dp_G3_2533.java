package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_dp_G3_2533 {

	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[][] dp;

	public static void dfs(int node) {
		visited[node] = true;
		if (graph[node].size() == 0)
			return;

		for (int i = 0; i < graph[node].size(); i++) {
			int next = graph[node].get(i);
			if (visited[next])
				continue;
			dfs(next);
			dp[node][0] += Math.min(dp[next][0], dp[next][1]);
			dp[node][1] += dp[next][0];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][2];
		visited = new boolean[N + 1];

		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		// 0: 얼리어답터일 때, 1: 아닐 때
		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1;
		}

		dfs(1);

		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
}