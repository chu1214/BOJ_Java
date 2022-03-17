package boj.dc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dc_S3_19637 {

	static int N, M;
	static String[] nickName;
	static int[] powerLimit;

	public static int matching(int left, int right, int power) {
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			if (power <= powerLimit[mid]) {
				right = mid - 1;
			} else
				left = mid + 1;
		}
		return right + 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nickName = new String[N];
		powerLimit = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			nickName[i] = st.nextToken();
			powerLimit[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int power = Integer.parseInt(br.readLine());
			sb.append(nickName[matching(0, N - 1, power)] + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}