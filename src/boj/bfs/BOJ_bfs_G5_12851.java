package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_bfs_G5_12851 {

	static int N, K, size, time = 0, cnt = 0;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void bfs(int start, int target) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);

		while (!q.isEmpty()) {
			int s = q.size();
			ArrayList<Integer> list = new ArrayList<>();

			while (s-- > 0) {
				int cur = q.poll();
				if (cur == target) {
					cnt++;
					while (!q.isEmpty()) {
						if (target == q.poll()) {
							cnt++;
						}
					}
					return;
				}
				for (int i = 0; i < graph[cur].size(); i++) {
					int next = graph[cur].get(i);
					if (next <= size && !visited[next]) {
						list.add(next);
						q.offer(next);
					}
				}
			}
			for (int i = 0; i < list.size(); i++)
				visited[list.get(i)] = true;
			time++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		size = Math.max(N, K) * 2;
		graph = new ArrayList[size + 1];
		for (int i = 0; i <= size; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i <= size; i++) {
			if (i > 0)
				graph[i].add(i - 1);
			if (i < 200000)
				graph[i].add(i + 1);
			if (i <= 100000)
				graph[i].add(i * 2);
		}

		visited = new boolean[size + 1];
		bfs(N, K);

		System.out.println(time + "\n" + cnt);
	}
}