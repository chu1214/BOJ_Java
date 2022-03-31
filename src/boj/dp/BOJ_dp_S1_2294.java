package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_S1_2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coin = new int[N + 1];
		int[] dp = new int[100001];

		for (int i = 1; i <= N; i++) {
			dp[coin[i]] = 1;
		}

		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				if (i >= coin[j]) {
					dp[i] = Math.min(dp[i], dp[i - coin[j]] + coin[j]);
				}
			}
		}

		System.out.println(dp[K]);
	}

}
