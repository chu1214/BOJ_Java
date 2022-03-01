package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_dfs_S1_2178 {

	static int N, M, ans = 1;
	static int[][] maze;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void bfs(int R, int C) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { R, C });
		visited[R][C] = true;
		int cnt = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			while (size-- > 0) {
				int[] cur = q.poll();
				if(cur[0] == N && cur[1] == M) {
					System.out.println(cnt);
					return;
				}
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (!isIn(nr, nc) || maze[nr][nc] == 0 || visited[nr][nc])
						continue;
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 1 && nr <= N && nc >= 1 && nc <= M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				maze[i][j + 1] = str.charAt(j) - '0';
			}
		}

		bfs(1, 1);
	}
}