package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_recursive_G1_1799 {

	static int N, maxB, maxW;
	static int[][] board;
	static boolean[] leftDown;
	static boolean[] rightDown;

	public static void putB(int cnt, int empty, int r, int c) {
		if (maxB > cnt + empty)
			return;

		if (r == N - 1 && c >= N)
			return;

		if (c >= N) {
			r++;
			c = c % N;
			if (N % 2 == 0) {
				if (c == 0)
					c++;
				else
					c--;
			}
		}

		for (int i = r; i < N; i++) {
			for (int j = c; j < N; j += 2) {
				if (board[i][j] != 0 && !leftDown[i + j] && !rightDown[i - j + N - 1]) {
					if (maxB < cnt + 1)
						maxB = cnt + 1;
					leftDown[i + j] = true;
					rightDown[i - j + N - 1] = true;
					putB(cnt + 1, empty - 1, i, j + 2);
					leftDown[i + j] = false;
					rightDown[i - j + N - 1] = false;
				}
				if (j >= N - 2) {
					c = (j + 2) % N;
					if (N % 2 == 0) {
						if (c == 0)
							c++;
						else
							c--;
					}
				}
			}
		}
	}

	public static void putW(int cnt, int empty, int r, int c) {
		if (maxW > cnt + empty)
			return;

		if (r == N - 1 && c >= N)
			return;

		if (c >= N) {
			r++;
			c = c % N;
			if (N % 2 == 0) {
				if (c == 0)
					c++;
				else
					c--;
			}
		}

		for (int i = r; i < N; i++) {
			for (int j = c; j < N; j += 2) {
				if (board[i][j] != 0 && !leftDown[i + j] && !rightDown[i - j + N - 1]) {
					if (maxW < cnt + 1)
						maxW = cnt + 1;
					leftDown[i + j] = true;
					rightDown[i - j + N - 1] = true;
					putW(cnt + 1, empty - 1, i, j + 2);
					leftDown[i + j] = false;
					rightDown[i - j + N - 1] = false;
				}
				if (j >= N - 2) {
					c = (j + 2) % N;
					if (N % 2 == 0) {
						if (c == 0)
							c++;
						else
							c--;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		leftDown = new boolean[2 * N - 1];
		rightDown = new boolean[2 * N - 1];
		maxB = 0;
		maxW = 0;
		int emptyB = 0;
		int emptyW = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					if ((i + j) % 2 == 0) {
						emptyB++;
					} else {
						emptyW++;
					}
				}
			}
		}

		putB(0, emptyB, 0, 0);
		putW(0, emptyW, 0, 1);

		System.out.println(maxB + maxW);
	}
}