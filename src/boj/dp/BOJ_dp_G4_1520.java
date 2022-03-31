package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_G4_1520 {

	static int M, N;
	static int[][] map;
	static int[][] dp;
	static int[] dm = { -1, 1, 0, 0 };
	static int[] dn = { 0, 0, -1, 1 };

	public static int dfs(int m, int n) {
		if (m == M - 1 && n == N - 1) {
			return 1;
		}

		if (dp[m][n] != -1) {
			return dp[m][n];
		}

		dp[m][n] = 0;
		for (int d = 0; d < 4; d++) {
			int nm = m + dm[d];
			int nn = n + dn[d];
			if (!isIn(nm, nn))
				continue;
			if (map[nm][nn] < map[m][n]) {
				dp[m][n] += dfs(nm, nn);
			}
		}
		return dp[m][n];
	}

	public static boolean isIn(int nm, int nn) {
		return nm >= 0 && nm < M && nn >= 0 && nn < N;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		dfs(0, 0);

		System.out.println(dp[0][0]);
	}
}