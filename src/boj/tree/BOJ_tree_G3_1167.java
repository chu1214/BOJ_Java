package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_tree_G3_1167 {

	static class Edge {
		int next, far;

		public Edge(int next, int far) {
			super();
			this.next = next;
			this.far = far;
		}
	}

	static int V, maxIdx = 0, ans = Integer.MIN_VALUE;
	static ArrayList<Edge>[] list;
	static boolean[] visited;

	public static void dfs(int cur, int sum) {
		visited[cur] = true;
		for (int i = 0; i < list[cur].size(); i++) {
			if (visited[list[cur].get(i).next])
				continue;
			dfs(list[cur].get(i).next, sum + list[cur].get(i).far);
		}
		if (sum > ans) {
			ans = sum;
			maxIdx = cur;
		}
		visited[cur] = false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];
		visited = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = 0;
			int c = 0;
			while (st.hasMoreTokens()) {
				b = Integer.parseInt(st.nextToken());
				if (b == -1)
					break;
				c = Integer.parseInt(st.nextToken());
				list[a].add(new Edge(b, c));
			}
		}

		dfs(2, 0);
		dfs(maxIdx, 0);

		System.out.println(ans);
	}
}