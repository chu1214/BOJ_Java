package boj.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_twopointer_G4_1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] nums = new int[N + 1];
		int min = Integer.MAX_VALUE;
		int sum = 0;
		int s = 1;
		int e = 1;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		while (e <= N) {
			if (sum < S) {
				sum += nums[e++];
				if (e == N + 1) {
					while (sum >= S) {
						sum -= nums[s++];
						min = Math.min(min, e - s + 1);
					}
				}
			} else if (sum >= S) {
				sum -= nums[s++];
				min = Math.min(min, e - s + 1);
			}
		}

		if (min == Integer.MAX_VALUE) {
			min = 0;
		}

		System.out.println(min);
	}
}