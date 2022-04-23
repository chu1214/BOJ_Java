package boj.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_binarysearch_G2_3745 {

	static int N;
	static int[] stock, rising;

	public static int search(int left, int right, int target) {
		int mid;

		while (left < right) {
			mid = (left + right) / 2;
			if (rising[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str = "";
		while ((str = br.readLine()) != null) {
			N = Integer.parseInt(str.trim());

			stock = new int[N + 1];
			rising = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				stock[i] = Integer.parseInt(st.nextToken());
			}

			int idx = 0;
			int len = 0;

			for (int i = 1; i <= N; i++) {
				if (rising[len] < stock[i]) {
					rising[++len] = stock[i];
				} else {
					idx = search(0, len, stock[i]);
					rising[idx] = stock[i];
				}
			}
			sb.append(len + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}