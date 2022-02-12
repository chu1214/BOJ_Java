package boj.dp;

import java.io.*;

public class BOJ_dp_S3_2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] stairs = new int[N];
		int[] dp = new int[N];

		for (int i = 0; i < N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = stairs[0];
		if (N == 1) {
			System.out.println(dp[N - 1]);
			System.exit(0);
		}
		dp[1] = stairs[0] + stairs[1];
		if (N == 2) {
			System.out.println(dp[N - 1]);
			System.exit(0);
		}
		dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
		if (N == 3) {
			System.out.println(dp[N - 1]);
			System.exit(0);
		}
		
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i]);
		}

		System.out.println(dp[N - 1]);
	}
}