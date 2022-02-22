package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_S1_1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] houses = new int[N + 1][3];
		int[][] dp = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				houses[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[1][0] = houses[1][0];
		dp[1][1] = houses[1][1];
		dp[1][2] = houses[1][2];

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = Math.min(dp[i-1][(j + 1) % 3], dp[i-1][(j + 2) % 3]) + houses[i][j];
			}
		}
		
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	}
}