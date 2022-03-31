package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_dp_S1_11057 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[N + 1][10];
		int sum = 0;

		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= j; k++)
					dp[i][j] += dp[i - 1][k] % 10007;
			}
		}
		for (int i = 0; i <= 9; i++) {
			sum = (sum + dp[N][i]) % 10007;
		}

		System.out.println(sum);
	}
}