package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_dijkstra_G3_1238 {

	static class Node implements Comparable<Node> {
		int node, cost;

		public Node(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	static int N, M, X;
	static ArrayList<Node>[] edge;
	static boolean[] visited;
	static int[][] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		edge = new ArrayList[N + 1];
		distance = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			edge[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edge[a].add(new Node(b, c));
		}

		for (int i = 1; i <= N; i++) {
			PriorityQueue<Node> pq = new PriorityQueue<>();
			Arrays.fill(distance[i], Integer.MAX_VALUE);
			visited = new boolean[N + 1];
			distance[i][i] = 0;
			pq.add(new Node(i, 0));

			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				if (visited[cur.node])
					continue;
				for (int j = 0; j < edge[cur.node].size(); j++) {
					Node next = edge[cur.node].get(j);
					if (distance[i][next.node] > distance[i][cur.node] + next.cost) {
						distance[i][next.node] = distance[i][cur.node] + next.cost;
						pq.offer(new Node(next.node, distance[i][next.node]));
					}
				}
				visited[cur.node] = true;
			}
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (ans < distance[i][X] + distance[X][i]) {
				ans = distance[i][X] + distance[X][i];
			}
		}
		System.out.println(ans);
	}
}