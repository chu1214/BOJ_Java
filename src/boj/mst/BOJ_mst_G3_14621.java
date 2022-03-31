package boj.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_mst_G3_14621 {

	static class Edge implements Comparable<Edge> {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static int N, M;
	static char[] school;
	static ArrayList<Edge> edges;
	static int[] parents;
	static int total;

	public static void makeParent() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	public static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;
		parents[a] = b;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		school = new char[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			school[i] = st.nextToken().charAt(0);
		}

		edges = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (school[a] != school[b])
				edges.add(new Edge(a, b, c));
		}

		edges.sort(null);

		makeParent();

		int cost = 0;
		int cnt = 0;

		for (int i = 0; cnt < N - 1 && i < edges.size(); i++) {
			Edge edge = edges.get(i);
			if (union(edge.from, edge.to)) {
				cost += edge.cost;
				cnt++;
			}
		}
		if (cnt < N - 1)
			cost = -1;
		System.out.println(cost);
	}
}