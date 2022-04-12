package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_math_S5_2581 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		boolean[] nums = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			nums[i] = true;
		}

		int idx = 2;
		while (idx <= N) {
			for (int i = idx + 1; i <= N; i++) {
				if (i % idx == 0)
					nums[i] = false;
			}
			for (int i = idx + 1; i <= N; i++) {
				if (nums[i]) {
					idx = i;
					break;
				}
				if (i == N) {
					idx = N + 1;
					break;
				}
			}
			if (idx == N)
				idx++;
		}

		int min = 10001;
		int sum = 0;
		for (int i = N; i >= M; i--) {
			if (nums[i]) {
				min = i;
				sum += i;
			}
		}

		if (min == 10001) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
