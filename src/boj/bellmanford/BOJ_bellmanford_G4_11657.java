package boj.bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_bellmanford_G4_11657 {

	static class Edge {
		int node, cost;

		public Edge(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}
	}

	static int N, M;
	static ArrayList<Edge>[] graph;
	static long[] distance;
	static final long INF = 100000000000L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		distance = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Edge(b, c));
		}

		Arrays.fill(distance, INF);
		distance[1] = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < graph.length; j++) {
				for (Edge next : graph[j]) {
					if (distance[j] == INF)
						continue;
					if (distance[next.node] > distance[j] + next.cost) {
						distance[next.node] = distance[j] + next.cost;
						if (i == N) {
							System.out.println(-1);
							System.exit(0);
						}
					}
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (distance[i] == INF)
				distance[i] = -1;
			sb.append(distance[i] + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}