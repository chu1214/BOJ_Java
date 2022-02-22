package boj.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_dp_G4_17404 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] houses = new int[N + 1][3];
		int[][][] dp = new int[3][N + 1][3];
		
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j <= N; j++) {
				for(int k = 0; k < 3; k++) {
					dp[i][j][k] = 10000000;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				houses[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][1][0] = houses[1][0];
		dp[1][1][1] = houses[1][1];
		dp[2][1][2] = houses[1][2];

		for (int a = 0; a < 3; a++) {
			for (int i = 2; i <= N; i++) {
				for (int j = 0; j < 3; j++) {
					if(i < N) {
						dp[a][i][j] = Math.min(dp[a][i - 1][(j + 1) % 3], dp[a][i - 1][(j + 2) % 3]) + houses[i][j];
					}
					else {
						if(a != j)
						dp[a][i][j] = Math.min(dp[a][i - 1][(j + 1) % 3], dp[a][i - 1][(j + 2) % 3]) + houses[i][j];
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int a = 0; a < 3; a++) {
			for (int j = 0; j < 3; j++) {
				if(min > dp[a][N][j] && dp[a][N][j] != 0) min = dp[a][N][j];
			}
		}
		System.out.println(min);
	}
}