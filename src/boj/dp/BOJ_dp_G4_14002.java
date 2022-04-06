package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_dp_G4_14002 {

	static int N;
	static int[] dp;
	static int[][] memo;
	static Stack<Integer> s = new Stack<>();

	public static int search(int left, int right, int num) {
		int mid = 0;

		while (left < right) {
			mid = (left + right) / 2;
			if (dp[mid] < num) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return right;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		memo = new int[N + 1][2];

		Arrays.fill(dp, Integer.MIN_VALUE);
		int len = 0;
		int idx = 0;

		int[] ans = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > dp[len]) {
				dp[++len] = num;
				memo[i][0] = num;
				memo[i][1] = len;
			} else {
				idx = search(0, len, num);
				dp[idx] = num;
				memo[i][0] = num;
				memo[i][1] = idx;
			}
		}
		sb.append(len + "\n");

		int size = N + 1;
		while (size-- > 0) {
			if (memo[size][1] == len) {
				s.push(memo[size][0]);
				len--;
			}
			if (len == 0)
				break;
		}
		while (!s.isEmpty()) {
			sb.append(s.pop() + " ");
		}
		sb.setLength(sb.length() - 1);

		System.out.println(sb.toString());
	}
}