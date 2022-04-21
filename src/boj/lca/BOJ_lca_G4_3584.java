package boj.lca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_lca_G4_3584 {

	static int[] parent, depth;
	static boolean[] check;
	static boolean[] notRoot;

	static ArrayList<Integer>[] graph;

	public static void dfs(int node, int d) {
		check[node] = true;
		depth[node] = d;

		for (int i = 0; i < graph[node].size(); i++) {
			int next = graph[node].get(i);
			if (check[next])
				continue;
			parent[next] = node;
			dfs(next, d + 1);
		}
	}

	public static int LCA(int a, int b) {
		while (depth[a] != depth[b]) {
			if (depth[a] > depth[b]) {
				a = parent[a];
			} else {
				b = parent[b];
			}
		}

		if (a == b) {
			return a;
		}

		while (parent[a] != parent[b]) {
			a = parent[a];
			b = parent[b];
		}

		return parent[a];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());

			graph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}

			notRoot = new boolean[N + 1];
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				notRoot[b] = true;
			}

			parent = new int[N + 1];
			depth = new int[N + 1];
			check = new boolean[N + 1];

			for (int i = 1; i <= N; i++) {
				if (notRoot[i] == false) {
					dfs(i, 0);
					break;
				}
			}

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(LCA(a, b) + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}