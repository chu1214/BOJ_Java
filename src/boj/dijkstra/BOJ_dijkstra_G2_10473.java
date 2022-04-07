package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_dijkstra_G2_10473 {

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

	static int N;
	static double sr, sc, er, ec;
	static double ans = 0;
	static ArrayList<Pos> list;
	static double[] time;
	static boolean[] visited;
	static final int INF = 1000000000;

	public static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, 0));
		time[0] = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.node])
				continue;
			visited[cur.node] = true;

			double r = list.get(cur.node).r;
			double c = list.get(cur.node).c;

			for (int i = 0; i < list.size(); i++) {
				if (i == cur.node)
					continue;
				double nr = list.get(i).r;
				double nc = list.get(i).c;
				if (cur.node == 0) {
					time[i] = getDistance(r, c, nr, nc) / 5;
					pq.offer(new Edge(i, time[i]));
				} else {
					double temp1 = getDistance(r, c, nr, nc) / 5;
					double temp2 = 2 + Math.abs(getDistance(r, c, nr, nc) - 50) / 5;
					double temp = Math.min(temp1, temp2);
					if (time[i] > time[cur.node] + temp) {
						time[i] = time[cur.node] + temp;
						pq.offer(new Edge(i, time[i]));
					}
				}
			}
		}
	}

	public static double getDistance(double fr, double fc, double lr, double lc) {
		return Math.sqrt(Math.pow((fr - lr), 2) + Math.pow((fc - lc), 2));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		sr = Double.parseDouble(st.nextToken());
		sc = Double.parseDouble(st.nextToken());

		st = new StringTokenizer(br.readLine());
		er = Double.parseDouble(st.nextToken());
		ec = Double.parseDouble(st.nextToken());

		N = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		list.add(new Pos(sr, sc));

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double cr = Double.parseDouble(st.nextToken());
			double cc = Double.parseDouble(st.nextToken());

			list.add(new Pos(cr, cc));
		}
		list.add(new Pos(er, ec));

		visited = new boolean[N + 2];
		time = new double[N + 2];
		Arrays.fill(time, INF);

		dijkstra();

		System.out.printf("%.6f", time[N + 1]);
	}
}