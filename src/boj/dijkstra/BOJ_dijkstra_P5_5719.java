package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_dijkstra_P5_5719 {

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

	static int N, M, S, D;
	static ArrayList<Edge>[] graph;
	static ArrayList<Integer>[] back;
	static boolean[][] visited;
	static int[] distance;
	static final int INF = 99999999;

	public static void dfs(int cur) {
		for (int i = 0; i < back[cur].size(); i++) {
			int next = back[cur].get(i);
			if (visited[next][cur])
				continue;
			visited[next][cur] = true;
			dfs(next);
		}
	}

	public static void dijkstra() {
		distance = new int[N];
		Arrays.fill(distance, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(S, 0));
		distance[S] = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.cost > distance[cur.node])
				continue;
			for (int i = 0; i < graph[cur.node].size(); i++) {
				Edge next = graph[cur.node].get(i);
				if (visited[cur.node][next.node])
					continue;
				if (distance[next.node] > distance[cur.node] + next.cost) {
					back[next.node].clear();
					back[next.node].add(cur.node);
					distance[next.node] = distance[cur.node] + next.cost;
					pq.offer(new Edge(next.node, distance[next.node]));
				} else if (distance[next.node] == distance[cur.node] + next.cost) {
					back[next.node].add(cur.node);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str;
		while (!(str = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());

			graph = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
			}

			back = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				back[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				graph[a].add(new Edge(b, c));
			}

			visited = new boolean[N][N];

			dijkstra();
			if (distance[D] == INF) {
				sb.append("-1\n");
			} else {
				dfs(D);
				dijkstra();
				if (distance[D] == INF) {
					sb.append("-1\n");
				} else {
					sb.append(distance[D] + "\n");
				}
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}