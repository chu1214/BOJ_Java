package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_G5_2166 {

	static class Dot {
		long x, y;

		public Dot(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Dot[] dots = new Dot[N];

		double ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dots[i] = new Dot(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		}

		double cal1 = 0;
		double cal2 = 0;

		for (int i = 0; i < N - 1; i++) {
			cal1 += dots[i].x * dots[i + 1].y;
			cal2 += dots[i].y * dots[i + 1].x;
		}

		cal1 += dots[N - 1].x * dots[0].y;
		cal2 += dots[N - 1].y * dots[0].x;

		ans = Math.abs(cal1 - cal2) / 2;

		System.out.printf("%.1f", ans);
	}
}