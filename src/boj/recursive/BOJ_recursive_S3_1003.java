package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_recursive_S3_1003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] fibo = new int[N + 1][2];

			if (N == 0) {
				sb.append("1 0\n");
			} else {

				fibo[0][0] = 1;
				fibo[0][1] = 0;

				fibo[1][0] = 0;
				fibo[1][1] = 1;

				for (int i = 2; i <= N; i++) {
					fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
					fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
				}

				sb.append(fibo[N][0] + " " + fibo[N][1] + "\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}