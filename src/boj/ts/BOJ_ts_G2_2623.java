package boj.ts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_ts_G2_2623 {

	static int N, M;
	static int[] degree;
	static ArrayList<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();

	public static void topologicalSort() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur + "\n");
			for (int j = 0; j < graph[cur].size(); j++) {
				int next = graph[cur].get(j);
				degree[next]--;
				if (degree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		degree = new int[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int cur = 0;
			int prev = 0;
			while (st.hasMoreTokens()) {
				cur = Integer.parseInt(st.nextToken());
				if (prev != 0) {
					graph[prev].add(cur);
					degree[cur]++;
				}
				prev = cur;
			}
		}
		topologicalSort();
		boolean check = true;
		for (int i = 1; i <= N; i++) {
			if (degree[i] != 0) {
				check = false;
				break;
			}
		}
		if (check) {
			sb.setLength(sb.length() - 1);
			System.out.println(sb.toString());
		} else {
			System.out.println(0);
		}
	}
}