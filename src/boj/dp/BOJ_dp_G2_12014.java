package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_G2_12014 {

	static int T, N, K;
	static int[] price;
	static int[] buy;

	public static int search(int left, int right, int key) {
		int mid;

		while (left < right) {
			mid = (left + right) / 2;
			if (buy[mid] < key) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			price = new int[N + 1];
			buy = new int[K + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			int len = 0;
			int idx = 0;
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if (buy[len] < price[i]) {
					buy[++len] = price[i];
					if (len == K) {
						ans = 1;
						break;
					}
				} else {
					idx = search(0, len, price[i]);
					buy[idx] = price[i];
				}
			}

			sb.append("Case #" + t + "\n" + ans + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}