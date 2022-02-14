package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_recursive_S1_1074 {

	static int N, R, C;
	static int cnt = 0;

	public static void Z(int n, int r, int c) {
		if (n == 1) {
			return;
		}
		if (r < n / 2 && c < n / 2) {
			Z(n / 2, r, c);
		} else if (r < n / 2 && c >= n / 2) {
			cnt += (n * n / 4);
			Z(n / 2, r, c - n / 2);
		} else if (r >= n / 2 && c < n / 2) {
			cnt += (n * n / 4) * 2;
			Z(n / 2, r - n / 2, c);
		} else {
			cnt += (n * n / 4) * 3;
			Z(n / 2, r - n / 2, c - n / 2);

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int n = (int) Math.pow(2, N);

		Z(n, R, C);

		System.out.println(cnt);
	}
}