package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_bfs_G4_2636 {

	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void melt(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (isIn(nr, nc) && map[nr][nc] == 9) {
				map[r][c] = 0;
				break;
			}
		}
	}

	public static boolean check() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 1)
					return false;
			}
		}
		return true;
	}

	public static void air(int r, int c) {
		map[r][c] = 9;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!isIn(nr, nc) || visited[nr][nc])
				continue;
			if (map[nr][nc] != 1) {
				visited[nr][nc] = true;
				air(nr, nc);
			}
		}
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		int last = 0;

		while (!check()) {
			visited = new boolean[R][C];
			last = 0;

			visited[0][0] = true;
			air(0, 0);

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] == 1) {
						last++;
						melt(r, c);
					}
				}
			}
			time++;
		}
		System.out.println(time + "\n" + last);
	}
}