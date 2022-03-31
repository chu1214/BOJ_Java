package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_dp_B3_2747 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] fibo = new int[N + 1];

		fibo[1] = 1;

		for (int i = 2; i <= N; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}

		System.out.println(fibo[N]);
	}

}