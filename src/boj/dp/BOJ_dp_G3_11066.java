package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_G3_11066 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			int[] page = new int[K + 1];
			int[] sum = new int[K + 1];
			int[][] dp = new int[K + 1][K + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				page[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i - 1] + page[i];
			}

			for (int i = 1; i <= K; i++) {
				for (int j = 1; j <= K - i; j++) {
					dp[j][j + i] = 1000000000;
					for (int k = j; k < j + i; k++) {
						dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i] + sum[i + j] - sum[j - 1]);
					}
				}
			}
			sb.append(dp[1][K] + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}