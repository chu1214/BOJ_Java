package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_simul_G3_16236 {

	static int N, remain = 0, ans = 0;
	static int[][] map, deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[] babyShark;

	public static class Pos implements Comparable<Pos> {
		int r, c, d;

		public Pos(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public int compareTo(Pos o) {
			if (this.d == o.d) {
				if (this.r == o.r) {
					return Integer.compare(this.c, o.c);
				}
				return Integer.compare(this.r, o.r);
			}
			return Integer.compare(this.d, o.d);
		}

	}

	public static void eatFish(int r, int c) {
		while (true) {
			Queue<Pos> q = new ArrayDeque<>();
			List<Pos> fish = new ArrayList<>();
			boolean[][] visited = new boolean[N][N];
			q.offer(new Pos(r, c, 0));
			visited[r][c] = true;

			while (!q.isEmpty()) {
				Pos shark = q.poll();

				for (int d = 0; d < 4; d++) {
					int nr = shark.r + deltas[d][0];
					int nc = shark.c + deltas[d][1];
					if (!isIn(nr, nc) || visited[nr][nc])
						continue;
					if (0 < map[nr][nc] && map[nr][nc] < babyShark[3]) {
						q.offer(new Pos(nr, nc, shark.d + 1));
						fish.add(new Pos(nr, nc, shark.d + 1));
						visited[nr][nc] = true;
					} else if (map[nr][nc] == 0 || map[nr][nc] == babyShark[3]) {
						q.offer(new Pos(nr, nc, shark.d + 1));
						visited[nr][nc] = true;
					}
				}
			}

			if (fish.size() == 0) {
				System.out.println(ans);
				return;
			}

			fish.sort(null);

			Pos target = fish.get(0);

			ans += target.d;
			babyShark[4]--;
			map[target.r][target.c] = 0;

			if (babyShark[3] == 0) {
				babyShark[2]++;
				babyShark[3] = babyShark[3];
			}

			r = target.r;
			c = target.c;
		}

	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		babyShark = new int[4];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					babyShark[0] = i;
					babyShark[1] = j;
					map[i][j] = 0;
				}
			}
		}

		babyShark[2] = 2;
		babyShark[3] = 2;

		eatFish(babyShark[0], babyShark[1]);
	}

}
