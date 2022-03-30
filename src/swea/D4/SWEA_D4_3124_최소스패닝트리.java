package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_D4_3124_최소스패닝트리 {

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

	static int T, V, E;
	static ArrayList<Edge>[] graph;
	static boolean[] visited;
	static int[] distance;
	static StringBuilder sb = new StringBuilder();

	public static void prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		long result = 0;
		int cnt = 0;
		pq.offer(new Edge(1, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (visited[cur.node])
				continue;

			visited[cur.node] = true;
			result += cur.cost;
			if (++cnt == V) {
				break;
			}

			for (int i = 0; i < graph[cur.node].size(); i++) {
				Edge next = graph[cur.node].get(i);
				if (!visited[next.node]) {
					pq.offer(new Edge(next.node, next.cost));
				}
			}
		}
		sb.append(result + "\n");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			sb.append("#" + t + " ");

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			graph = new ArrayList[V + 1];

			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());

				graph[A].add(new Edge(B, C));
				graph[B].add(new Edge(A, C));
			}

			visited = new boolean[V + 1];
			distance = new int[V + 1];

			prim();
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}