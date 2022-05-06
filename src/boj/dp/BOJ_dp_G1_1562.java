package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_dp_G1_1562 {

	static final long INF = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[][][] dp = new long[N + 1][10][1 << 10];
		long ans = 0;

		for (int i = 1; i <= 9; i++) {
			dp[1][i][1 << i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k < (1 << 10); k++) {
					if (j > 0 && dp[i - 1][j - 1][k] != 0) {
						dp[i][j][k | (1 << j)] += dp[i - 1][j - 1][k];
						dp[i][j][k | (1 << j)] %= INF;
					}
					if (j < 9 && dp[i - 1][j + 1][k] != 0) {
						dp[i][j][k | (1 << j)] += dp[i - 1][j + 1][k];
						dp[i][j][k | (1 << j)] %= INF;
					}
				}
			}
		}
		for (int i = 0; i <= 9; i++) {
			ans += dp[N][i][1023];
			ans %= INF;
		}

		System.out.println(ans);
	}
}