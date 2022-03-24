package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_greedy_G5_2212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int[] sensor = new int[N];
		int[] dif = new int[N - 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sensor);

		for (int i = 0; i < N - 1; i++) {
			dif[i] = sensor[i + 1] - sensor[i];
		}

		Arrays.sort(dif);

		int sum = 0;

		for (int i = 0; i <= dif.length - K; i++) {
			sum += dif[i];
		}

		System.out.println(sum);
	}
}