package boj.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_binarysearch_G2_1365 {

	static int N;
	static int[] pole, length;

	public static int search(int left, int right, int target) {
		int mid = 0;

		while (left < right) {
			mid = (left + right) / 2;
			if (length[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		pole = new int[N + 1];
		length = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			pole[i] = Integer.parseInt(st.nextToken());
		}

		int idx = 0;
		int len = 0;

		for (int i = 1; i <= N; i++) {
			if (length[len] < pole[i]) {
				length[++len] = pole[i];
			} else {
				idx = search(0, len, pole[i]);
				length[idx] = pole[i];
			}
		}
		System.out.println(N - len);
	}
}