package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_bfs_G4_1600 {

	static class Monkey {
		int h, w, k;

		public Monkey(int h, int w, int k) {
			super();
			this.h = h;
			this.w = w;
			this.k = k;
		}
	}

	static int K, W, H, ans = -1;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dh = { -1, 1, 0, 0, 2, 2, -2, -2, 1, 1, -1, -1 };
	static int[] dw = { 0, 0, -1, 1, 1, -1, 1, -1, 2, -2, 2, -2 };

	public static void bfs(int h, int w, int k) {
		Queue<Monkey> q = new ArrayDeque<>();
		visited[h][w][k] = true;
		q.offer(new Monkey(h, w, k));

		int D = 0;
		int cnt = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Monkey cur = q.poll();
				if (cur.h == H - 1 && cur.w == W - 1) {
					ans = cnt;
					return;
				}
				if (cur.k > 0)
					D = 12;
				else
					D = 4;
				for (int d = 0; d < D; d++) {
					int nh = cur.h + dh[d];
					int nw = cur.w + dw[d];
					int ver = D == 0 || d >= 4 ? cur.k - 1 : cur.k;
					if (!isIn(nh, nw) || visited[nh][nw][ver] || map[nh][nw] == 1)
						continue;

					if (d >= 4)
						q.offer(new Monkey(nh, nw, cur.k - 1));
					else
						q.offer(new Monkey(nh, nw, cur.k));
					visited[nh][nw][ver] = true;
				}
			}
			cnt++;
		}
	}

	public static boolean isIn(int nh, int nw) {
		return nh >= 0 && nh < H && nw >= 0 && nw < W;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for (int w = 0; w < W; w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(0, 0, K);

		System.out.println(ans);
	}
}
