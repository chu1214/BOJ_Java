package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_bfs_G4_1261 {
	static int N, M, ans = 0;
	static int[][] spot;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void bfs(int startR, int startC) {
		LinkedList<int[]> list = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		list.addFirst(new int[] { startR, startC, 0 });
		visited[startR][startC] = true;

		while (!list.isEmpty()) {
			int[] cur = list.poll();
			int r = cur[0];
			int c = cur[1];
			int cost = cur[2];

			if (r == N - 1 && c == M - 1) {
				ans = cost;
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!isIn(nr, nc) || visited[nr][nc])
					continue;
				if (spot[nr][nc] == 0) {
					list.addFirst(new int[] { nr, nc, cost });
				} else {
					list.addLast(new int[] { nr, nc, cost + 1 });
				}
				visited[nr][nc] = true;
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

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				spot[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0);

		System.out.println(ans);
	}
}