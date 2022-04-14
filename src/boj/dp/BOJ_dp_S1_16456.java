package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_dp_S1_16456 {

	static int N;
	static long[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new long[N + 1];

		if (N >= 1)
			dp[1] = 1;
		if (N >= 2)
			dp[2] = 1;
		if (N >= 3)
			dp[3] = 2;

		if (N >= 4)
			for (int i = 4; i <= N; i++) {
				dp[i] = (dp[i - 1] + dp[i - 3]) % 1000000009;
			}

		System.out.println(dp[N]);
	}
}
