package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_sort_G5_2230 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] nums = new int[N];
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(nums);

		int left = 0;
		int right = 0;

		while (left < N && right < N) {
			int dif = nums[right] - nums[left];
			if (dif < M)
				right++;
			else {
				ans = Math.min(ans, dif);
				left++;
			}
		}

		System.out.println(ans);
	}

}
