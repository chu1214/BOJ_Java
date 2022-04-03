package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_B3_3009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] x = new int[1001];
		int[] y = new int[1001];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			x[Integer.parseInt(st.nextToken())]++;
			y[Integer.parseInt(st.nextToken())]++;
		}

		for (int i = 1; i <= 1000; i++) {
			if (x[i] == 1) {
				sb.append(i + " ");
			}
		}

		for (int i = 1; i <= 1000; i++) {
			if (y[i] == 1) {
				sb.append(i);
			}
		}
		System.out.println(sb.toString());
	}
}
