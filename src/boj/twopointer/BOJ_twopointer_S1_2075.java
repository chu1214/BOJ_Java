package boj.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_twopointer_S1_2075 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] chart = new int[N][N];
		int[] level = new int[N];

		Arrays.fill(level, N - 1);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				chart[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		int max = 0;
		while (cnt < N) {
			max = Integer.MIN_VALUE;
			int idx = -1;
			for (int i = 0; i < N; i++) {
				if (max < chart[level[i]][i]) {
					max = chart[level[i]][i];
					idx = i;
				}
			}
			level[idx]--;
			cnt++;
		}
		System.out.println(max);
	}
}