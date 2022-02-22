package boj.bfs;

import java.io.*;
import java.util.*;

public class BOJ_bfs_S1_16928 {

	static int N, M, ans = 0;
	static int[] map;

	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[101];
		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			ans++;
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				for (int n = 1; n <= 6; n++) {
					if (cur + n >= 100)
						return;
					if (!visited[map[cur + n]]) {
						visited[map[cur + n]] = true;
						q.offer(map[cur + n]);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[101];

		for (int i = 1; i <= 100; i++) {
			map[i] = i;
		}

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x] = y;
		}

		bfs(1);

		System.out.println(ans);
	}

}