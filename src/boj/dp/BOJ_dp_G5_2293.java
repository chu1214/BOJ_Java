package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_G5_2293 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coin = new int[N + 1];
		int[] dp = new int[K + 1];

		for (int i = 1; i <= N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				if (coin[i] <= j) {
					dp[j] += dp[j - coin[i]];
				}
			}
		}

		System.out.println(dp[K]);
	}
}