package boj.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_twopointer_S3_2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		int ans = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int value = A[0];

		while (end < N) {
			if (value == M)
				ans++;
			if (value < M) {
				end++;
				if (end >= N)
					break;
				value += A[end];
			} else {
				value -= A[start];
				start++;
			}
		}

		System.out.println(ans);
	}

}
