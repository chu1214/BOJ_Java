package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_bfs_G1_1194 {

	static class MS {
		int r, c, key;

		public MS(int r, int c, int key) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
		}
	}

	static int N, M, cnt;
	static char[][] maze;
	static boolean[][][] visited;
	static boolean find = false;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void bfs(int sr, int sc) {
		Queue<MS> q = new ArrayDeque<>();
		q.offer(new MS(sr, sc, 0));
		cnt = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				MS cur = q.poll();
				if (maze[cur.r][cur.c] == '1') {
					find = true;
					return;
				}

				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					int nkey = cur.key;

					if (!isIn(nr, nc) || maze[nr][nc] == '#' || visited[nr][nc][nkey])
						continue;
					if (maze[nr][nc] >= 'a' && maze[nr][nc] <= 'f') {
						if ((nkey & 1 << maze[nr][nc] - 'a') == 0) {
							nkey |= (1 << maze[nr][nc] - 'a');
						}
					} else if (maze[nr][nc] >= 'A' && maze[nr][nc] <= 'F') {
						if ((nkey & 1 << maze[nr][nc] - 'A') == 0)
							continue;
					}
					visited[nr][nc][nkey] = true;
					q.offer(new MS(nr, nc, nkey));
				}

			}
			cnt++;
		}
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new char[N][M];
		visited = new boolean[N][M][1 << 7];

		int sr = 0;
		int sc = 0;

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				maze[r][c] = str.charAt(c);
				if (maze[r][c] == '0') {
					sr = r;
					sc = c;
				}
			}
		}
		bfs(sr, sc);

		if (find) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
	}
}