package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_B2_1009 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		int[][] pattern = { { 10, 10, 10, 10 }, { 1, 1, 1, 1 }, { 2, 4, 8, 6 }, { 3, 9, 7, 1 }, { 4, 6, 4, 6 },
				{ 5, 5, 5, 5 }, { 6, 6, 6, 6 }, { 7, 9, 3, 1 }, { 8, 4, 2, 6 }, { 9, 1, 9, 1 } };

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int i = a % 10;
			int j = (b - 1) % 4;

			sb.append(pattern[i][j] + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}