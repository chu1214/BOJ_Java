package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_dp_G5_9251 {

	static Integer[][] dp;
	static char[] arr1, arr2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();

		arr1 = new char[str1.length()];
		arr2 = new char[str2.length()];

		arr1 = str1.toCharArray();
		arr2 = str2.toCharArray();

		dp = new Integer[arr1.length][arr2.length];

		System.out.println(LCS(arr1.length - 1, arr2.length - 1));
	}

	static int LCS(int x, int y) {

		if (x == -1 || y == -1) {
			return 0;
		}

		if (dp[x][y] == null) {
			dp[x][y] = 0;

			if (arr1[x] == arr2[y]) {
				dp[x][y] = LCS(x - 1, y - 1) + 1;
			}

			else {
				dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
			}
		}

		return dp[x][y];
	}
}