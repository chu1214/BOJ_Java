package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_dijkstra_G5_1916 {

	public static class Edge implements Comparable<Edge> {
		int node, cost;

		public Edge(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}

	static final int INF = 1000000000;
	static int N, M, S, E;
	static ArrayList<Edge>[] graph;
	static int[] distance;
	static boolean[] visited;

	public static void dijkstra(int start) {
		visited = new boolean[N + 1];
		distance = new int[N + 1];

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Arrays.fill(distance, INF);
		distance[start] = 0;

		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (visited[cur.node])
				continue;

			for (int i = 0; i < graph[cur.node].size(); i++) {
				Edge next = graph[cur.node].get(i);
				if (distance[next.node] > distance[cur.node] + next.cost) {
					distance[next.node] = distance[cur.node] + next.cost;
					pq.offer(new Edge(next.node, distance[next.node]));
				}
			}
			visited[cur.node] = true;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];

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

		st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		dijkstra(S);

		System.out.println(distance[E]);
	}
}