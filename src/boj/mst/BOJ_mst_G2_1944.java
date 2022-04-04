package boj.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_mst_G2_1944 {

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static class Edge implements Comparable<Edge> {
		int from, to, dist;

		public Edge(int from, int to, int dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.dist, o.dist);
		}

	}

	static int N, M, pointCnt = 0, ans = 0, edgeCnt = 0;
	static char[][] maze;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[] parent;
	static ArrayList<Pos> keys = new ArrayList<>();
	static ArrayList<Edge> edges = new ArrayList<>();

	public static void makeParent() {
		parent = new int[M + 1];
		for (int i = 0; i <= M; i++) {
			parent[i] = i;
		}
	}

	public static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;
		parent[b] = a;
		return true;
	}

	public static void bfs(int r, int c, int idx) {
		Queue<Pos> q = new ArrayDeque<>();
		visited = new boolean[N][N];
		q.offer(new Pos(r, c));
		visited[r][c] = true;
		int cnt = 0;
		int exit = pointCnt - 1;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Pos cur = q.poll();
				if (cnt != 0 && (maze[cur.r][cur.c] == 'S' || maze[cur.r][cur.c] == 'K')) {
					for (int i = 0; i <= M; i++) {
						if (keys.get(i).r == cur.r && keys.get(i).c == cur.c)
							edges.add(new Edge(idx, i, cnt));
					}
					exit--;
				}
				if (exit == 0)
					return;
				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					if (!isIn(nr, nc) || visited[nr][nc] || maze[nr][nc] == '1')
						continue;
					visited[nr][nc] = true;
					q.offer(new Pos(nr, nc));
				}
			}
			cnt++;
		}
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nr <= N;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				maze[i][j] = str.charAt(j);
				if (maze[i][j] == 'S' || maze[i][j] == 'K') {
					keys.add(new Pos(i, j));
					pointCnt++;
				}
			}
		}

		for (int i = 0; i <= M; i++) {
			Pos cur = keys.get(i);
			bfs(cur.r, cur.c, i);
		}

		boolean check = false;

		if (edges.size() != 0) {
			edges.sort(null);

			makeParent();

			for (int i = 0; i < edges.size(); i++) {
				Edge cur = edges.get(i);

				if (union(cur.from, cur.to)) {
					ans += cur.dist;
					edgeCnt++;
				}

				if (edgeCnt + 1 == pointCnt) {
					check = true;
					break;
				}
			}
		}
		if (!check)
			ans = -1;
		System.out.println(ans);
	}
}