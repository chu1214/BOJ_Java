package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_dp_S4_17626 {

	static int N;
	static int[] dp;
	static final int INF = 100001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1];
		Arrays.fill(dp, INF);

		for (int i = 0; i <= Math.sqrt(N); i++) {
			dp[i * i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= Math.sqrt(i); j++) {
				dp[i] = Math.min(dp[i], dp[i - (j * j)] + dp[j * j]);
			}
		}

		System.out.println(dp[N]);
	}
}