package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_3307_최장증가부분수열_ver_DP {

	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int max = Integer.MIN_VALUE;

			arr = new int[N];
			dp = new int[N];

			Arrays.fill(dp, 1);

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i < N; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
						if (dp[i] > max)
							max = dp[i];
					}
				}
			}
			sb.append("#" + t + " " + max + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
