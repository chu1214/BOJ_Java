package boj.ts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_ts_G2_1766 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] degree = new int[N + 1];

		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			degree[B]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				pq.offer(i);
			}
		}

		while (!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur + " ");

			for (int i = 0; i < graph[cur].size(); i++) {
				int next = graph[cur].get(i);
				degree[next]--;
				if (degree[next] == 0) {
					pq.offer(next);
				}
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}