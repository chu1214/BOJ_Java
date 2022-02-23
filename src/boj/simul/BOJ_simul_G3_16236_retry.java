package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_simul_G3_16236_retry {
	static class Shark extends Fish {
		int size, eat;

		public Shark(int r, int c, int size, int eat, int distance) {
			super(r, c, distance);
			this.size = size;
			this.eat = eat;
		}
	}

	static class Fish implements Comparable<Fish> {
		int r, c, distance;

		public Fish(int r, int c, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.distance = distance;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.distance == o.distance) {
				if (this.r == o.r) {
					return Integer.compare(this.c, o.c);
				}
				return Integer.compare(this.r, o.r);
			}
			return Integer.compare(this.distance, o.distance);
		}

	}

	static int N, ans = 0;
	static int[][] space, deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static Shark bs;

	public static void bfs(Shark bs) {
		while (true) {
			Queue<Shark> q = new ArrayDeque<>();
			ArrayList<Fish> list = new ArrayList<>();
			boolean[][] visited = new boolean[N][N];
			q.offer(bs);
			visited[bs.r][bs.c] = true;

			while (!q.isEmpty()) {
				Shark cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur.r + deltas[d][0];
					int nc = cur.c + deltas[d][1];
					if (isIn(nr, nc) && !visited[nr][nc]) {
						if (space[nr][nc] > 0 && space[nr][nc] < cur.size) {
							q.offer(new Shark(nr, nc, cur.size, cur.eat, cur.distance + 1));
							list.add(new Fish(nr, nc, cur.distance + 1));
							visited[nr][nc] = true;
						} else if (space[nr][nc] == 0 || space[nr][nc] == cur.size) {
							q.offer(new Shark(nr, nc, cur.size, cur.eat, cur.distance + 1));
							visited[nr][nc] = true;
						}
					}
				}
			}

			if (list.size() == 0) {
				System.out.println(ans);
				return;
			}

			list.sort(null);

			Fish target = list.get(0);

			ans += target.distance;
			bs.eat++;
			space[target.r][target.c] = 0;

			if (bs.eat == bs.size) {
				bs.size++;
				bs.eat = 0;
			}

			bs.r = target.r;
			bs.c = target.c;
		}
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		space = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if (space[i][j] == 9) {
					space[i][j] = 0;
					bs = new Shark(i, j, 2, 0, 0);
				}
			}
		}
		bfs(bs);
	}
}