package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_greedy_G5_16678 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] honor = new long[N];

		int cnt = 0;
		long sum = 0;

		for (int i = 0; i < N; i++) {
			honor[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(honor);

		for (int i = 0; i < N; i++) {
			if (honor[i] - (cnt + 1) >= 0) {
				sum += honor[i] - (cnt + 1);
				cnt++;
			}
		}

		System.out.println(sum);
	}
}