package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_S1_9465 {

	static int T, N;
	static int[][] sticker;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			sticker = new int[2][N];
			dp = new int[2][N];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			if (N > 1) {
				dp[0][1] = dp[1][0] + sticker[0][1];
				dp[1][1] = dp[0][0] + sticker[1][1];
			}
			for (int i = 2; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					dp[j][i] = Math.max(dp[j == 0 ? 1 : 0][i - 1] + sticker[j][i],
							dp[j == 0 ? 1 : 0][i - 2] + sticker[j][i]);
				}
			}
			sb.append(dp[0][N - 1] > dp[1][N - 1] ? dp[0][N - 1] + "\n" : dp[1][N - 1] + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}