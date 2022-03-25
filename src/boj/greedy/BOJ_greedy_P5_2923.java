package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_greedy_P5_2923 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] oA = new int[101];
		int[] oB = new int[101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			oA[a]++;
			oB[b]++;

			int[] A = new int[101];
			int[] B = new int[101];

			for (int j = 1; j < 101; j++) {
				A[j] = oA[j];
				B[j] = oB[j];
			}

			int ai = 100;
			int bi = 0;

			int max = Integer.MIN_VALUE;

			while (true) {
				while (ai >= 1 && A[ai] == 0) {
					ai--;
				}
				if (ai < 1)
					break;

				while (bi <= 100 && B[bi] == 0) {
					bi++;
				}
				if (bi > 100)
					break;

				max = Math.max(max, ai + bi);

				int cnt = Math.min(A[ai], B[bi]);
				A[ai] -= cnt;
				B[bi] -= cnt;
			}

			sb.append(max + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}