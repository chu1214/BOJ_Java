package boj.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_dp_S1_12852 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int[][] dp = new int[N + 1][2];
		dp[1][0] = 0;

		for (int i = 2; i <= N; i++) {
			if (i % 6 == 0) {
				dp[i][0] = Math.min(Math.min(dp[i / 3][0], dp[i / 2][0]), dp[i - 1][0]) + 1;
				dp[i][1] = dp[i / 3][0] < dp[i - 2][0] ? (dp[i / 3][0] < dp[i - 1][0] ? i / 3 : i - 1)
						: (dp[i / 2][0] < dp[i - 1][0] ? i / 2 : i - 1);
			} else if (i % 3 == 0) {
				dp[i][0] = Math.min(dp[i / 3][0], dp[i - 1][0]) + 1;
				dp[i][1] = dp[i / 3][0] < dp[i - 1][0] ? i / 3 : i - 1;
			} else if (i % 2 == 0) {
				dp[i][0] = Math.min(dp[i / 2][0], dp[i - 1][0]) + 1;
				dp[i][1] = dp[i / 2][0] < dp[i - 1][0] ? i / 2 : i - 1;
			} else {
				dp[i][0] = dp[i - 1][0] + 1;
				dp[i][1] = i - 1;
			}
		}

		bw.write(dp[N][0] + "\n");
		while (N != 0) {
			bw.write(N + " ");
			N = dp[N][1];
		}
		bw.flush();
		bw.close();
	}

}