package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_dp_G3_24525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] arr = new char[str.length() + 1];
		int[] dp = new int[str.length() + 1];

		int min = 200001;
		int max = -100001;
		int ans = -1;
		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
			if (arr[i] == 'S')
				sum += 2;
			else if (arr[i] == 'K')
				sum += -1;

			if (sum > max)
				max = sum;
			if (sum < min)
				min = sum;
			dp[i + 1] = sum;
		}

		if (min > 0)
			min = 0;
		int[][] check = new int[max - min + 2][3];

		if (str.length() >= 3) {
			for (int i = 0; i <= str.length(); i++) {
				int cur = dp[i] - min;
				if (check[cur][2] == 0) {
					check[cur][0] = i;
					check[cur][2] = 1;
				} else {
					check[cur][1] = i;
					if (cur != dp[i - 1] - min) {
						check[cur][2] = 2;
					}
					if (check[cur][2] == 2) {
						ans = Math.max(ans, check[cur][1] - check[cur][0]);
					}
				}
			}
		}

		System.out.println(ans);
	}
}