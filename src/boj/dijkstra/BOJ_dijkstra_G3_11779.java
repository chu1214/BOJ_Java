package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_dijkstra_G3_11779 {

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
	static ArrayList<Integer>[] route;
	static int[] pre;
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
					pre[next.node] = cur.node;
					pq.offer(new Edge(next.node, distance[next.node]));
				}
			}
			visited[cur.node] = true;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		route = new ArrayList[N + 1];
		pre = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			route[i] = new ArrayList<>();
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

		sb.append(distance[E] + "\n");

		Stack<Integer> s = new Stack<>();
		s.push(E);
		while (pre[E] != 0) {
			s.push(pre[E]);
			E = pre[E];
		}

		sb.append(s.size() + "\n");

		while (!s.isEmpty()) {
			sb.append(s.pop() + " ");
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}