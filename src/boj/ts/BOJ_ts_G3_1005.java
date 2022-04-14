package boj.ts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_ts_G3_1005 {

	static int T, N, K, W;
	static int[] time;
	static int[] result;
	static int[] degree;
	static ArrayList<Integer>[] graph;

	public static void topologicalSort() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				result[i] = time[i];
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < graph[cur].size(); i++) {
				int next = graph[cur].get(i);
				degree[next]--;
				if (result[next] < time[next] + result[cur]) {
					result[next] = time[next] + result[cur];
				}
				if (degree[next] == 0) {
					if (next == W)
						break;
					q.offer(next);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			time = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}

			degree = new int[N + 1];
			graph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				graph[a].add(b);
				degree[b]++;
			}

			W = Integer.parseInt(br.readLine());

			result = new int[N + 1];
			topologicalSort();

			sb.append(result[W] + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}