package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_recursive_S3_15654 {

	static int N, M;
	static int[] numbers;
	static int[] selected;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();

	public static void permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < selected.length; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				selected[cnt] = numbers[i];
				permutation(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[N];
		selected = new int[M];
		isSelected = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		permutation(0);

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}