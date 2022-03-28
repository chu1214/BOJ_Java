package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_G5_17070 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		int[][][] dp = new int[N][N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N; i++) {
			if (map[0][i] == 1)
				break;
			dp[0][i][0] = 1;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if (map[i][j] == 1)
					continue;
				for (int k = 0; k < 3; k++) {
					if (k == 0) {
						dp[i][j][k] += dp[i][j - 1][k] + dp[i][j - 1][k + 1];
					} else if (k == 1 && map[i][j - 1] != 1 && map[i - 1][j] != 1) {
						dp[i][j][k] += dp[i - 1][j - 1][k - 1] + dp[i - 1][j - 1][k] + dp[i - 1][j - 1][k + 1];
					} else if (k == 2) {
						dp[i][j][k] += dp[i - 1][j][k - 1] + dp[i - 1][j][k];
					}
				}
			}
		}

		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);

	}

}