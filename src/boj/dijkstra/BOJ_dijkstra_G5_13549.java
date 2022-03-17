package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_dijkstra_G5_13549 {

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

	static final int INF = 98765432;
	static int N, K, ans = Integer.MAX_VALUE;
	static ArrayList<Node>[] list;
	static int[] distance;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int size = Math.max(N, K);

		list = new ArrayList[size * 2 + 1];
		distance = new int[size * 2 + 1];
		visited = new boolean[size * 2 + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < list.length; i++) {
			if (i - 1 >= 0)
				list[i].add(new Node(i - 1, 1));
			if (i + 1 <= size * 2)
				list[i].add(new Node(i + 1, 1));
			if (i * 2 <= size * 2)
				list[i].add(new Node(i * 2, 0));
		}

		Arrays.fill(distance, 98765432);
		distance[N] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(N, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.node])
				continue;
			visited[cur.node] = true;

			for (int i = 0; i < list[cur.node].size(); i++) {
				Node next = list[cur.node].get(i);
				if (distance[next.node] > distance[cur.node] + next.cost) {
					distance[next.node] = distance[cur.node] + next.cost;
					pq.offer(new Node(next.node, distance[next.node]));
				}
			}
		}
		System.out.println(distance[K]);
	}
}