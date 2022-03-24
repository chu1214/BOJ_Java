package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_greedy_S2_15729 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		int[] target = new int[N];
		int[] hm = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			target[i] = Integer.parseInt(st.nextToken());
			if (target[i] != hm[i]) {
				cnt++;
				if (i < N - 1) {
					hm[i + 1] = hm[i + 1] == 0 ? 1 : 0;
				}
				if (i < N - 2) {
					hm[i + 2] = hm[i + 2] == 0 ? 1 : 0;
				}
			}
		}

		System.out.println(cnt);
	}
}