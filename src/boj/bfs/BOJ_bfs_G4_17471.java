package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_bfs_G4_17471 {

	static int N, popA, popB, ans = Integer.MAX_VALUE;
	static int[] population;
	static ArrayList<Integer>[] graph;

	public static boolean check(int start, int cnt, int choosed, boolean team) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		q.offer(start);
		visited[start] = true;
		cnt--;
		if (team)
			popA += population[start];
		else
			popB += population[start];

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < graph[cur].size(); i++) {
				int next = graph[cur].get(i);
				if (visited[next])
					continue;
				if (((choosed & 1 << next) != 0) == team) {
					q.offer(next);
					visited[next] = true;
					cnt--;
					if (team)
						popA += population[next];
					else
						popB += population[next];
				}
			}
		}
		if (cnt == 0)
			return true;
		return false;
	}

	public static void divide(int cnt, int choosed) {
		if (ans == 0)
			return;
		if (cnt == N + 1) {
			int teamA = 0;
			int aCnt = 0;
			int teamB = 0;
			int bCnt = 0;

			for (int i = 1; i <= N; i++) {
				if ((choosed & 1 << i) != 0) {
					teamA = i;
					aCnt++;
				} else {
					teamB = i;
					bCnt++;
				}
			}

			if (aCnt == N || bCnt == N)
				return;

			popA = 0;
			popB = 0;

			if (check(teamA, aCnt, choosed, true) && check(teamB, bCnt, choosed, false)) {
				ans = Math.min(ans, Math.abs(popA - popB));
			}

			return;
		}

		divide(cnt + 1, choosed | 1 << cnt);
		divide(cnt + 1, choosed);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		population = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int limit = Integer.parseInt(st.nextToken());
			for (int j = 0; j < limit; j++) {
				int adj = Integer.parseInt(st.nextToken());
				graph[i].add(adj);
			}
		}

		divide(1, 0);

		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}
}