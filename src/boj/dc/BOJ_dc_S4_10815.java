package boj.dc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_dc_S4_10815 {

	static int N, M;
	static int[] card;
	static int[] ans;

	public static int binarysearch(int left, int right, int target) {
		while (left <= right) {
			int mid = (left + right) / 2;

			if (card[mid] < target) {
				left = mid + 1;
			} else if (target < card[mid]) {
				right = mid - 1;
			} else {
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		card = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(card);

		M = Integer.parseInt(br.readLine());
		ans = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			ans[i] = binarysearch(0, card.length - 1, target);
		}

		for (int i = 0; i < M; i++) {
			sb.append(ans[i] + " ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}