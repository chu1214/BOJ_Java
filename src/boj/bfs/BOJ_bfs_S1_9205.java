package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_bfs_S1_9205 {

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int T, N;
	static ArrayList<Pos> list;
	static boolean[] visited;

	public static boolean bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);
		visited[0] = true;

		while (!q.isEmpty()) {
			Pos cur = list.get(q.poll());
			for (int i = 1; i < N + 2; i++) {
				Pos next = list.get(i);
				if (visited[i])
					continue;
				int distance = Math.abs(next.x - cur.x) + Math.abs(next.y - cur.y);
				if (distance <= 1000) {
					if (i == N + 1) {
						return true;
					}
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();

			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				list.add(new Pos(x, y));
			}

			visited = new boolean[list.size()];
			if (bfs())
				sb.append("happy\n");
			else
				sb.append("sad\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}