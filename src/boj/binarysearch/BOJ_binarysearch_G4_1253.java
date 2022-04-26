package boj.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_binarysearch_G4_1253 {

	static int N, ans;
	static int[] nums;
	static HashMap<Integer, Integer> m = new HashMap<>();
	static boolean[] isGood;

	public static void search(int l, int r, int t) {
		int m;

		while (l < r) {
			m = (l + r) / 2;
			if (nums[m] < t) {
				l = m + 1;
			} else if (nums[m] > t) {
				r = m;
			} else {
				isGood[m] = true;
				return;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		isGood = new boolean[N];
		ans = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
		}

		Arrays.sort(nums);

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int sum = nums[i] + nums[j];
				if (((nums[i] != 0 || nums[j] != 0)
						&& ((sum != nums[i] && sum != nums[j]) || m.getOrDefault(sum, 0) >= 2))
						|| m.getOrDefault(sum, 0) >= 3) {
					search(0, N, sum);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (isGood[i])
				ans += m.get(nums[i]);
		}

		System.out.println(ans);
	}
}