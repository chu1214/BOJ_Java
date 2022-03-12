package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_dfs_S3_15270 {

	static int N, M, ans = 1;
	static ArrayList<Integer>[] friends;
	static boolean[] dancing;
	static boolean isMax = false;

	public static void dfs(int idx, int cnt, int limit) {
		if (cnt == limit || cnt == limit - 1) {
			ans = limit;
			isMax = true;
			return;
		}

		for (int i = idx; i <= N; i++) {
			if (!dancing[i]) {
				for (int j = 0; j < friends[i].size(); j++) {
					if (!dancing[friends[i].get(j)]) {
						dancing[i] = true;
						dancing[friends[i].get(j)] = true;
						dfs(i + 1, cnt + 2, limit);
						if(isMax) return;
						dancing[i] = false;
						dancing[friends[i].get(j)] = false;
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

		friends = new ArrayList[N + 1];
		dancing = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			friends[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			friends[u].add(v);
			friends[v].add(u);
		}

		int limit = 0;
		for (int i = 1; i <= N; i++) {
			if (friends[i].size() > 0) {
				limit++;
			}
		}
		
		if(limit % 2 == 0 && limit != N) {
			limit++;
		}
		
		if (limit != 1) {
			for (int i = limit; i >= 2; i--) {
				dfs(1, 0, i);
				if(isMax) break;
			}
		} else ans = 1;
		System.out.println(ans);
	}
}