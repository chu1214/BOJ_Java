package boj.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_mst_G4_1922 {

	static class Edge implements Comparable<Edge> {
		int node, cost;

		public Edge(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	static int N, M;
	static ArrayList<Edge>[] graph;
	static boolean[] visited;
	static int[] distance;
	static int total, cnt;

	public static void prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		total = 0;
		cnt = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.node])
				continue;

			visited[cur.node] = true;
			total += cur.cost;
			cnt++;

			if (cnt == N) {
				System.out.println(total);
				return;
			}

			for (int i = 0; i < graph[cur.node].size(); i++) {
				Edge next = graph[cur.node].get(i);
				if (visited[next.node])
					continue;
				pq.offer(next);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
		}

		prim();
	}
}