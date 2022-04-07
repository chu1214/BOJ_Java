package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int T, N, M, R, C, L, ans;
	static int[][] turnel;
	static boolean[][] visited;
	static int[][] dr = { {}, { -1, 1, 0, 0 }, { -1, 1 }, { 0, 0 }, { -1, 0 }, { 1, 0 }, { 1, 0 }, { -1, 0 } };
	static int[][] dc = { {}, { 0, 0, -1, 1 }, { 0, 0 }, { -1, 1 }, { 0, 1 }, { 0, 1 }, { 0, -1 }, { 0, -1 } };

	public static void bfs() {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(R, C));
		visited[R][C] = true;
		int cnt = 1;
		ans++;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Pos cur = q.poll();
				int r = cur.r;
				int c = cur.c;
				int shape = turnel[cur.r][cur.c];

				if (cnt == L) {
					return;
				}

				for (int d = 0; d < dr[shape].length; d++) {
					int nr = r + dr[shape][d];
					int nc = c + dc[shape][d];
					if (!isIn(nr, nc) || visited[nr][nc] || turnel[nr][nc] == 0 || !check(r, c, nr, nc))
						continue;
					visited[nr][nc] = true;
					ans++;
					q.offer(new Pos(nr, nc));
				}
			}
			cnt++;
		}
	}

	public static boolean check(int r, int c, int nr, int nc) {
		for (int d = 0; d < dr[turnel[nr][nc]].length; d++) {
			int br = nr + dr[turnel[nr][nc]][d];
			int bc = nc + dc[turnel[nr][nc]][d];
			if (br == r && bc == c)
				return true;
		}
		return false;
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			turnel = new int[N][M];
			visited = new boolean[N][M];
			ans = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					turnel[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs();

			sb.append("#" + t + " " + ans + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}