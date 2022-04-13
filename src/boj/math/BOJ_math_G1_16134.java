package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_G1_16134 {

	static int N, R;
	static long[] fac;
	static final long MOD = 1000000007;

	public static long multiply(int n, int r, long b) {
		if (b == 1) {
			return fac[r] * fac[n - r] % MOD;
		}

		long half = multiply(n, r, b / 2);
		long res = half * half % MOD;

		if (b % 2 == 1) {
			res = res * multiply(n, r, 1) % MOD;
		}

		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		fac = new long[N + 1];
		fac[0] = 1;

		for (int i = 1; i <= N; i++) {
			fac[i] = i * fac[i - 1] % MOD;
		}

		long ans = fac[N] * multiply(N, R, MOD - 2) % MOD;

		System.out.println(ans);
	}

}
