package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWEA_D4_1249_보급로 {

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> point = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					point.add(str.charAt(j) - '0');
				}
			}

			ArrayList<Edge>[] graph = new ArrayList[N * N];
			for (int i = 0; i < N * N; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < point.size(); i++) {
				if (i % N != 0)
					graph[i].add(new Edge(i - 1, point.get(i - 1)));
				if (i % N != N - 1)
					graph[i].add(new Edge(i + 1, point.get(i + 1)));
				if (i / N != 0)
					graph[i].add(new Edge(i - N, point.get(i - N)));
				if (i / N != N - 1)
					graph[i].add(new Edge(i + N, point.get(i + N)));
			}

			boolean[] visited = new boolean[point.size()];
			int[] distance = new int[point.size()];
			Arrays.fill(distance, 1000000);

			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.offer(new Edge(0, 0));
			distance[0] = 0;

			while (!pq.isEmpty()) {
				Edge cur = pq.poll();
				if (visited[cur.node])
					continue;
				visited[cur.node] = true;

				for (int i = 0; i < graph[cur.node].size(); i++) {
					Edge next = graph[cur.node].get(i);
					if (distance[next.node] > distance[cur.node] + next.cost) {
						distance[next.node] = distance[cur.node] + next.cost;
						pq.offer(new Edge(next.node, distance[next.node]));
					}
				}
			}
			sb.append("#" + t + " " + distance[N * N - 1] + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}