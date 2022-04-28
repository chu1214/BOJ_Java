package boj.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_twopointer_G5_2470 {

	static int N;
	static long min, ans1, ans2;
	static long[] liquid;

	public static void search(int left, int right) {

		while (left < right) {
			long mix = liquid[left] + liquid[right];
			if (Math.abs(mix) < min) {
				min = Math.abs(mix);
				ans1 = liquid[left];
				ans2 = liquid[right];
			}
			if (mix < 0) {
				left++;
			} else {
				right--;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		liquid = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(liquid);

		min = Long.MAX_VALUE;
		ans1 = 0;
		ans2 = 0;
		search(0, N - 1);

		System.out.println(ans1 + " " + ans2);
	}
}