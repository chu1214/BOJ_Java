package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_G3_11049 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] l = new int[N];
		int[] r = new int[N];
		int[][] dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			l[i] = Integer.parseInt(st.nextToken());
			r[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N - i; j++) {
				dp[j][j + i] = Integer.MAX_VALUE;
				for (int k = 0; k < i; k++) {
					dp[j][j + i] = Math.min(dp[j][j + i],
							dp[j][j + k] + dp[j + k + 1][j + i] + l[j] * r[j + k] * r[j + i]);
				}
			}
		}
		System.out.println(dp[0][N - 1]);
	}
}