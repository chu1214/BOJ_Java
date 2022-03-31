package boj.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_mst_G3_1774 {

	static class Pos {
		double r, c;

		public Pos(double r, double c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static class Edge implements Comparable<Edge> {
		int node;
		double cost;

		public Edge(int node, double cost) {
			super();
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}

	static int N, M;
	static Pos[] god;
	static ArrayList<Edge>[] graph;
	static boolean[] visited;
	static double total;
	static int cnt;

	public static void prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, 0));

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
				System.out.printf("%.2f", total);
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		Pos[] gods = new Pos[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			double r = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());
			gods[i] = new Pos(r, c);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					double distance = Math.sqrt(Math.pow(Math.abs(gods[i].r - gods[j].r), 2)
							+ Math.pow(Math.abs(gods[i].c - gods[j].c), 2));
					graph[i].add(new Edge(j, distance));
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(new Edge(b, 0));
			graph[b].add(new Edge(a, 0));
		}

		prim();
	}
}