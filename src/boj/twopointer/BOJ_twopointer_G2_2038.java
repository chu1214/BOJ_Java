package boj.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_twopointer_G2_2038 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] fn = new long[15000001];
		long[] last = new long[15000001];

		fn[1] = 1;
		last[1] = 1;
		fn[2] = 2;
		last[2] = 3;

		int idx = 2;
		for (int i = 3; i <= 15000000; i++) {
			if (last[idx] < i)
				idx++;
			fn[i] = idx;
			last[i] = last[i - 1] + idx;
		}

		System.out.println(fn[N]);
	}

}
