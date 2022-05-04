package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_dp_G4_9252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr1 = br.readLine().toCharArray();
		char[] arr2 = br.readLine().toCharArray();

		int[][] dp = new int[arr1.length + 1][arr2.length + 1];

		for (int i = 0; i < arr1.length; i++)
			for (int j = 0; j < arr2.length; j++)
				dp[i + 1][j + 1] = arr1[i] == arr2[j] ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);

		StringBuilder answer = new StringBuilder();
		int i = arr1.length;
		int j = arr2.length;

		while (i >= 1 && j >= 1) {
			if (dp[i][j] == dp[i - 1][j])
				i--;
			else if (dp[i][j] == dp[i][j - 1])
				j--;
			else {
				answer.insert(0, arr2[j - 1]);
				i--;
				j--;
			}
		}
		System.out.println(answer.length());
		System.out.println(answer);

	}

}