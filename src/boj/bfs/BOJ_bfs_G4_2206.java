package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_bfs_G4_2206 {

	static class Node {
		int r, c, life;

		public Node(int r, int c, int life) {
			super();
			this.r = r;
			this.c = c;
			this.life = life;
		}
	}

	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void bfs(int r, int c) {
		Queue<Node> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[2][N][M];
		q.offer(new Node(0, 0, 1));
		visited[1][0][0] = true;

		int cnt = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Node cur = q.poll();
				if(cur.r == N - 1 && cur.c == M - 1) {
					System.out.println(cnt);
					return;
				}
	
				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					if (!isIn(nr, nc) || visited[cur.life][nr][nc] || (cur.life == 0 && map[nr][nc] == 1))
						continue;
					visited[cur.life][nr][nc] = true;
					if (cur.life == 1 && map[nr][nc] == 1) {
						q.offer(new Node(nr, nc, cur.life - 1));
					} else {
						q.offer(new Node(nr, nc, cur.life));
					}
				}
			}
			cnt++;
		}
		System.out.println(-1);
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0);
	}
}