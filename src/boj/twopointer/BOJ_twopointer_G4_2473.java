package boj.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_twopointer_G4_2473 {

	static int N;
	static long min, ans1, ans2, ans3;
	static long[] liquid;

	public static void search() {

		for (int i = 0; i < N; i++) {
			int k = i + 1;
			int j = N - 1;
			while (k < j) {
				long mix = liquid[i] + liquid[k] + liquid[j];
				if (Math.abs(mix) < min) {
					ans1 = liquid[i];
					ans2 = liquid[k];
					ans3 = liquid[j];
					min = Math.abs(mix);
				}

				if (mix < 0) {
					k++;
				} else {
					j--;
				}
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
		ans3 = 0;
		search();

		System.out.println(ans1 + " " + ans2 + " " + ans3);
	}

}