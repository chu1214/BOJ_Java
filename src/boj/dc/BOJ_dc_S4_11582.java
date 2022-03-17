package boj.dc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_dc_S4_11582 {

	static int N, K;
	static int[] chicken;

	public static void sortChicken(int num) {

		if (K == 1) {
			Arrays.sort(chicken);
			return;
		}

		for (int i = 0; i <= N - N / num; i += N / num) {
			Arrays.sort(chicken, i, i + N / num);
		}
		if (K == num)
			return;
		sortChicken(num / 2);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		chicken = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			chicken[i] = Integer.parseInt(st.nextToken());
		}

		K = Integer.parseInt(br.readLine());
		sortChicken(N);

		for (int i = 0; i < N; i++) {
			sb.append(chicken[i] + " ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}