package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_bfs_S1_1325 {

	static int N, M;
	static ArrayList<Integer>[] graph;
	static int[] num;
	static int max = 1;

	public static void bfs(int node) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		q.add(node);
		visited[node] = true;
		num[node]++;
		max = Math.max(max, num[node]);

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int cur = q.poll();
				for (int i = 0; i < graph[cur].size(); i++) {
					int next = graph[cur].get(i);
					if (!visited[next]) {
						num[next]++;
						visited[next] = true;
						q.offer(next);
						max = Math.max(num[next], max);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[N + 1];
		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
		}

		for (int i = 1; i <= N; i++) {
			bfs(i);
		}

		for (int i = 1; i <= N; i++) {
			if (num[i] == max) {
				sb.append(i + " ");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());

	}
}