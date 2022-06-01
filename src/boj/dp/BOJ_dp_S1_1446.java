package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_dp_S1_1446 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] dp = new int[10001];
		int[][] sc = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			sc[i][0] = from;
			sc[i][1] = to;
			sc[i][2] = distance;
		}

		Arrays.sort(sc, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});

		for (int i = 1; i <= 10000; i++) {
			dp[i] = dp[i - 1] + 1;
			for (int j = 0; j < sc.length; j++) {
				if (sc[j][1] == i && dp[i] > sc[j][2] + dp[sc[j][0]]) {
					dp[i] = sc[j][2] + dp[sc[j][0]];
				}
			}
		}

		System.out.println(dp[D]);
	}
}