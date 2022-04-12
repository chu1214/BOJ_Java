package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_math_G1_1019 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[10];
		int unit = 1;

		while (N >= 0) {
			while (N % 10 != 9 && N >= 0) {
				int temp = N;
				while (temp != 0) {
					cnt[temp % 10] += unit;
					temp /= 10;
				}
				N--;
			}
			if (N < 0)
				break;

			for (int i = 0; i <= 9; i++) {
				if (i == 0)
					cnt[i] += (N / 10) * unit;
				else {
					cnt[i] += (N / 10 + 1) * unit;
				}
			}

			N /= 10;
			unit *= 10;
		}

		for (int i = 0; i <= 9; i++) {
			sb.append(cnt[i] + " ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
