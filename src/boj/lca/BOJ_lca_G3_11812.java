package boj.lca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_lca_G3_11812 {

	static long N, K, Q, cnt;

	public static void LCA(long a, long b) {
		if (K == 1) {
			cnt = Math.abs(a - b);
			return;
		}

		while (a != b) {
			if (a > b) {
				a = (a - 1) / K;
			} else {
				b = (b - 1) / K;
			}
			cnt++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Long.parseLong(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			cnt = 0;
			LCA(x - 1, y - 1);

			sb.append(cnt + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}