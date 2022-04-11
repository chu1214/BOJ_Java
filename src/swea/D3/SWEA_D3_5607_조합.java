package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_5607_조합 {

	static int T, N, R;

	public static long power(long n, long m) {
		if (m == 0)
			return 1;
		long num = power(n, m / 2) % 1234567891;
		long save = num * num % 1234567891;
		if (m % 2 == 0)
			return save;
		else
			return (save * n) % 1234567891;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());

			long factorial[] = new long[N + 1];
			factorial[0] = 1;
			for (int i = 1; i <= N; i++) {
				factorial[i] = (factorial[i - 1] * i) % 1234567891;
			}

			long ans = (factorial[N] * power(factorial[R] * factorial[N - R] % 1234567891, 1234567891 - 2))
					% 1234567891;

			sb.append("#" + t + " " + ans + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}