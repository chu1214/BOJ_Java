package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_dijkstra_G4_1261 {

	static class Pos implements Comparable<Pos> {
		int r, c, cost;

		public Pos(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	static int N, M, ans = 0;
	static int[][] spot;
	static int[][] distance;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static final int INF = 100000000;

	public static void dijkstra(int startR, int startC) {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][M];
		pq.offer(new Pos(startR, startC, 0));
		distance[startR][startC] = 0;

		while (!pq.isEmpty()) {
			Pos cur = pq.poll();
			int r = cur.r;
			int c = cur.c;

			if (r == N - 1 && c == M - 1)
				return;

			if (visited[r][c])
				continue;
			visited[r][c] = true;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!isIn(nr, nc))
					continue;
				if (distance[nr][nc] > distance[r][c] + spot[nr][nc]) {
					distance[nr][nc] = distance[r][c] + spot[nr][nc];
					pq.offer(new Pos(nr, nc, distance[nr][nc]));
				}
			}
		}
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		spot = new int[N][M];
		distance = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				spot[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], INF);
		}

		dijkstra(0, 0);

		System.out.println(distance[N - 1][M - 1]);
	}
}