package boj.bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_bellmanford_G1_1219 {

	static class Edge {
		int node, cost;

		public Edge(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}
	}

	static int N, S, E, M;
	static int[] getMoney;
	static long[] total;
	static boolean[] visited;
	static Queue<Integer> cycle = new ArrayDeque<>();
	static ArrayList<Edge>[] graph;
	static final long INF = Long.MAX_VALUE;

	public static boolean check() {
		while (!cycle.isEmpty()) {
			int cur = cycle.poll();
			for (Edge next : graph[cur]) {
				if (visited[next.node])
					continue;
				visited[next.node] = true;
				cycle.offer(next.node);
			}
		}
		if (visited[E])
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Edge(b, c));
		}

		getMoney = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			getMoney[i] = Integer.parseInt(st.nextToken());
		}

		total = new long[N];
		Arrays.fill(total, INF);
		total[S] = -getMoney[S];
		visited = new boolean[N];

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (total[j] == INF)
					continue;
				for (Edge next : graph[j]) {
					if (total[next.node] > total[j] + next.cost - getMoney[next.node]) {
						total[next.node] = total[j] + next.cost - getMoney[next.node];
						if (i == N) {
							visited[j] = true;
							cycle.offer(j);
						}
					}
				}
			}
		}
		if (total[E] == INF)
			System.out.println("gg");
		else if (check())
			System.out.println("Gee");
		else
			System.out.println(-total[E]);
	}
}