package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_G3_7579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] m = new int[N + 1];
		int[] c = new int[N + 1];
		int[] dp = new int[N * 100 + 1];
		int max = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			max += c[i];
		}

		for (int i = 0; i < N; i++) {
			for (int j = max; j >= c[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - c[i]] + m[i]);
			}
		}

		for (int i = 0; i <= max; i++) {
			if (dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}
}