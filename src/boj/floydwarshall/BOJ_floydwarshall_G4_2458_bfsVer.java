package boj.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_floydwarshall_G4_2458_bfsVer {

	static int N, M, count;
	static ArrayList<Integer>[] graph;
	static int[] cnt;
	static boolean[] visited;

	public static void dfs(int cur) {
		count++;
		for (int i = 0; i < graph[cur].size(); i++) {
			int next = graph[cur].get(i);
			if (visited[next])
				continue;
			visited[next] = true;
			cnt[next]++;
			dfs(next);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = new int[N + 1];

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			count = 0;
			dfs(i);
			cnt[i] += count;
		}

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == N)
				ans++;
		}
		System.out.println(ans);
	}
}