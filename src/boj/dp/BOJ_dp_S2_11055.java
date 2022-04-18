package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_S2_11055 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int max = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		int[] dp = new int[max + 1];

		for (int i = 1; i <= N; i++) {
			int num = arr[i];
			for (int j = 0; j < num; j++) {
				dp[num] = Math.max(dp[num], dp[j] + num);
			}
		}

		int ans = 0;
		for (int i = 1; i <= max; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}