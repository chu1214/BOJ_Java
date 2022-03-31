package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_dp_S3_11727 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];

		if (N == 1) {
			System.out.println(1);
		} else {
			dp[1] = 1;
			dp[2] = 3;

			for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
			}

			System.out.println(dp[N]);
		}
	}
}