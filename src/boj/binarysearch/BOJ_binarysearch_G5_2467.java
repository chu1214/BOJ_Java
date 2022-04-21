package boj.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_binarysearch_G5_2467 {

	static int N, ans1, ans2, min;
	static int[] values;

	public static void search(int left, int right) {
		while (left < right) {
			int mix = Math.abs(values[left] + values[right]);
			if (mix < min) {
				min = mix;
				ans1 = values[left];
				ans2 = values[right];
			}
			if (values[left] + values[right] > 0) {
				right--;
			} else if (values[left] + values[right] < 0) {
				left++;
			} else {
				return;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		values = new int[N];
		ans1 = 0;
		ans2 = 0;
		min = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}

		search(0, N - 1);

		System.out.println(ans1 + " " + ans2);
	}
}