package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_G4_10830 {

	static int N;
	static long B;
	static long[][] A;

	public static long[][] mul(long b) {
		if (b == 1) {
			return A;
		}
		long[][] ans = new long[N][N];
		long[][] half = new long[N][N];

		half = mul(b / 2);
		ans = mul2(half, half);

		if (b % 2 == 1) {
			ans = mul2(ans, A);
		}

		return ans;
	}

	public static long[][] mul2(long[][] a1, long[][] a2) {
		long[][] result = new long[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					result[i][j] += a1[i][k] * a2[k][j];
					result[i][j] %= 1000;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		A = new long[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		A = mul(B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(A[i][j] % 1000 + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}