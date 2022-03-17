package boj.dc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_dc_S3_24460 {

	static int N;
	static int[][] chair;

	public static int raffle(int size, int sr, int sc, int er, int ec) {
		if (size == 1) {
			return chair[sr][sc];
		}

		int[] arr = new int[4];

		size = size / 2;
		arr[0] = raffle(size, sr, sc, er / 2, ec / 2);
		arr[1] = raffle(size, sr, sc + size, er / 2, ec);
		arr[2] = raffle(size, sr + size, sc, er, ec / 2);
		arr[3] = raffle(size, sr + size, sc + size, er, ec);

		Arrays.sort(arr);

		return arr[1];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		chair = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				chair[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(raffle(N, 0, 0, N, N));
	}
}