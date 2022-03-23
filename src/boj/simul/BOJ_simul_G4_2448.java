package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_simul_G4_2448 {

	static int N;
	static char[][] board;
	static StringBuilder sb = new StringBuilder();

	public static void star(int size, int r, int c) {
		if (size == 3) {
			board[r][c] = '*';
			board[r + 1][c - 1] = '*';
			board[r + 1][c + 1] = '*';
			for (int i = 0; i < 5; i++) {
				board[r + 2][c - 2 + i] = '*';
			}
			return;
		}
		size = size / 2;
		star(size, r, c);
		star(size, r + size, c - size);
		star(size, r + size, c + size);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new char[N][2 * N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N; j++) {
				board[i][j] = ' ';
			}
		}

		star(N, 0, N - 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}