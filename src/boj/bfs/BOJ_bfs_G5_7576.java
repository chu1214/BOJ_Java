package boj.bfs;

import java.io.*;
import java.util.*;

public class BOJ_bfs_G5_7576 {
	static int M, N;
	static int[][] tomatoes;
	static boolean[][] visited;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomatoes[i][j] == 1) {
					q.offer(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] now = q.poll();
				int r = now[0];
				int c = now[1];

				for (int d = 0; d < 4; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];

					if (isIn(nr, nc) && tomatoes[nr][nc] != -1 && !visited[nr][nc]) {
						tomatoes[nr][nc] = 1;
						visited[nr][nc] = true;
						q.offer(new int[] { nr, nc });
					}
				}
			}
			cnt++;
		}

		if (!check())
			return -1;

		return cnt - 1;
	}

	public static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomatoes[i][j] == 0)
					return false;
			}
		}

		return true;
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tomatoes = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomatoes[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
	}
}