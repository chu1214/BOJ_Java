import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_청정수컵_H번 {

	static final int MOD = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] sum = new long[N + 1];
		long[] fac = new long[100001];
		long ans = 0;

		fac[1] = 1;
		for (int i = 2; i <= 100000; i++) {
			fac[i] = (fac[i - 1] * i) % MOD;
		}

		for (int i = 1; i <= N; i++) {
			sum[i] = (sum[i - 1] + (i * 2)) % MOD;
		}

		for (int i = 1; i <= N; i++) {
			ans = (ans + (sum[i] * i)) % MOD;
		}

		System.out.println(ans + " " + ((fac[N] * fac[N]) % MOD));
	}
}
