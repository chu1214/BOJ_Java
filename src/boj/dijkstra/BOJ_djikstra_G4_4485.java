package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_djikstra_G4_4485 {

	static class Edge implements Comparable<Edge> {
		int r, c;
		int cost;

		public Edge(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	static int N;
	static int[][] cave;
	static ArrayList<Edge>[][] rupee;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] distance;

	public static void djikstra() {
		distance = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, 0, cave[0][0]));
		distance[0][0] = cave[0][0];

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.r][cur.c])
				continue;
			visited[cur.r][cur.c] = true;

			for (int i = 0; i < rupee[cur.r][cur.c].size(); i++) {
				Edge next = rupee[cur.r][cur.c].get(i);
				if (distance[next.r][next.c] > distance[cur.r][cur.c] + next.cost) {
					distance[next.r][next.c] = distance[cur.r][cur.c] + next.cost;
					pq.offer(new Edge(next.r, next.c, distance[next.r][next.c]));
				}
			}
		}
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = 1;

		while ((N = Integer.parseInt(br.readLine())) != 0) {
			cave = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			rupee = new ArrayList[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					rupee[i][j] = new ArrayList<>();
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (isIn(nr, nc)) {
							rupee[r][c].add(new Edge(nr, nc, cave[nr][nc]));
						}
					}
				}
			}

			djikstra();

			sb.append("Problem " + T + ": " + distance[N - 1][N - 1] + "\n");
			T++;
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}