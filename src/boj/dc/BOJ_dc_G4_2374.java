package boj.dc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_dc_G4_2374 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] A = new long[N];

		long sum = 0;

		A[0] = Integer.parseInt(br.readLine());

		long cur = A[0];
		long max = A[0];

		for (int i = 1; i < N; i++) {
			A[i] = Long.parseLong(br.readLine());
			if (cur > A[i]) {
				sum += cur - A[i];
			} else if (max < A[i]) {
				sum += A[i] - max;
			}
			if (max < A[i])
				max = A[i];
			cur = A[i];
		}
		System.out.println(sum);
	}
}