package boj.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_twopointer_G3_1644 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		boolean[] prime = new boolean[N + 1];
		Arrays.fill(prime, true);

		for (int i = 2; i <= N; i++) {
			if (prime[i]) {
				int k = i * 2;
				while (k <= N) {
					prime[k] = false;
					k += i;
				}
			}
		}

		int start = 2;
		int end = 2;
		long value = 2;
		int ans = 0;

		while (end <= N) {
			if (value < N) {
				while (true) {
					end++;
					if (end > N || prime[end])
						break;
				}
				if (end > N)
					break;
				value += end;
			} else if (value > N) {
				value -= start;
				while (true) {
					start++;
					if (start > end || prime[start])
						break;
				}
				if (start > end)
					break;
			} else {
				ans++;
				while (true) {
					end++;
					if (end > N || prime[end])
						break;
				}
				if (end > N)
					break;
				value += end;
			}
		}

		System.out.println(ans);
	}
}
