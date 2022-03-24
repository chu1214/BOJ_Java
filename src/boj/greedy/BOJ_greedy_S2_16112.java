package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_greedy_S2_16112 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());

		long[] stone = new long[N];

		long sum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			stone[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(stone);

		for (int i = 0; i < N; i++) {
			if (i > K)
				sum += K * stone[i];
			else
				sum += (long) i * stone[i];
		}

		System.out.println(sum);

	}
}