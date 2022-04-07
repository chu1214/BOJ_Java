package boj.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_floydwarshall_G5_21278 {

	static int N, M, ans = Integer.MAX_VALUE;
	static int[][] map;
	static final int INF = 100000000;
	static int[] store, best;

	public static void build(int cnt, int start) {
		if (cnt == 2) {
			int a = store[0];
			int b = store[1];
			int sum = 0;

			for (int i = 1; i <= N; i++) {
				sum += Math.min(map[a][i], map[b][i]);
			}

			if (sum < ans) {
				ans = sum;
				best[0] = store[0];
				best[1] = store[1];
			}
			return;
		}

		for (int i = start; i <= N; i++) {
			store[cnt] = i;
			build(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		store = new int[2];
		best = new int[2];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j)
					map[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (k == i)
					continue;
				for (int j = 1; j <= N; j++) {
					if (k == j || i == j)
						continue;
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		build(0, 1);

		Arrays.sort(best);
		System.out.println(best[0] + " " + best[1] + " " + ans * 2);
	}
}