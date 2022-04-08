package boj.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_mst_G1_2887 {

	static class Edge implements Comparable<Edge> {
		int distance, from, to;

		public Edge(int distance, int from, int to) {
			super();
			this.distance = distance;
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.distance, o.distance);
		}

	}

	static int N;
	static int[][] planetX, planetY, planetZ;
	static ArrayList<Edge> list;
	static int[] parents;

	public static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
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
		parents[b] = a;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		planetX = new int[N][2];
		planetY = new int[N][2];
		planetZ = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			planetX[i] = new int[] { x, i };
			planetY[i] = new int[] { y, i };
			planetZ[i] = new int[] { z, i };
		}

		Arrays.sort(planetX, (x, y) -> Integer.compare(x[0], y[0]));
		Arrays.sort(planetY, (x, y) -> Integer.compare(x[0], y[0]));
		Arrays.sort(planetZ, (x, y) -> Integer.compare(x[0], y[0]));

		list = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			list.add(new Edge(planetX[i + 1][0] - planetX[i][0], planetX[i][1], planetX[i + 1][1]));
			list.add(new Edge(planetY[i + 1][0] - planetY[i][0], planetY[i][1], planetY[i + 1][1]));
			list.add(new Edge(planetZ[i + 1][0] - planetZ[i][0], planetZ[i][1], planetZ[i + 1][1]));
		}

		list.sort(null);

		make();

		int distance = 0;
		int from = 0;
		int to = 0;

		int ans = 0;
		for (int i = 0; i < list.size(); i++) {
			distance = list.get(i).distance;
			from = list.get(i).from;
			to = list.get(i).to;

			if (union(from, to))
				ans += distance;
		}

		System.out.println(ans);
	}

}