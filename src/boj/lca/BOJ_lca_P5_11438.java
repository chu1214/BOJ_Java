package boj.lca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_lca_P5_11438 {

	static int logN = 21;
	static int N, M;
	static int[][] parent;
	static int[] depth;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;
		depth[start] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 0; i < graph[cur].size(); i++) {
				int next = graph[cur].get(i);
				if (visited[next])
					continue;
				visited[next] = true;
				parent[next][0] = cur;
				depth[next] = depth[cur] + 1;
				q.offer(next);
			}
		}
	}

	public static void setParent() {
		bfs(1);

		for (int i = 1; i < logN; i++) {
			for (int j = 1; j <= N; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
			}
		}
	}

	public static int lca(int x, int y) {
		if (depth[x] > depth[y]) {
			int temp = x;
			x = y;
			y = temp;
		}

		for (int i = logN - 1; i >= 0; i--) {
			if (depth[y] - depth[x] >= (1 << i)) {
				y = parent[y][i];
			}
		}

		if (x == y)
			return x;

		for (int i = logN - 1; i >= 0; i--) {
			if (parent[x][i] != parent[y][i]) {
				x = parent[x][i];
				y = parent[y][i];
			}
		}

		return parent[x][0];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		parent = new int[N + 1][logN];
		depth = new int[N + 1];
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		setParent();

		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append(lca(x, y) + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}