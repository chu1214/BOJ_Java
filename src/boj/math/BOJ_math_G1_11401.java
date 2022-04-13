package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_G1_11401 {

	static int N, K;
	static long[] fac;
	static final long MOD = 1000000007;

	public static long multiply(int n, int k, long b) {
		if (b == 1) {
			return fac[k] * fac[n - k] % MOD;
		}

		long half = multiply(n, k, b / 2);
		long res = half * half % MOD;

		if (b % 2 == 1) {
			res = (res * multiply(n, k, 1)) % MOD;
		}

		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		fac = new long[4000001];
		fac[0] = 1;

		for (int i = 1; i <= 4000000; i++) {
			fac[i] = (i * fac[i - 1]) % MOD;
		}

		long ans = fac[N] * multiply(N, K, MOD - 2) % MOD;

		System.out.println(ans);
	}
}