package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_simul_G4_2239 {

	static int[][] sudoku = new int[9][9];
	static int[][] use = new int[3][9];
	static boolean complete = false;
	static StringBuilder sb = new StringBuilder();

	public static boolean check(int r, int c, int k) {
		int shift = 1 << k;
		if ((use[0][r] & shift) > 0) {
			return false;
		} else if ((use[1][c] & shift) > 0) {
			return false;
		} else if ((use[2][r / 3 * 3 + c / 3] & shift) > 0) {
			return false;
		}

		return true;
	}

	public static void complete(int r, int c) {
		if (c == 9) {
			r++;
			c = 0;
		}

		if (r == 9) {
			complete = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			return;
		}

		if (sudoku[r][c] != 0) {
			complete(r, c + 1);
		}

		else {
			for (int k = 1; k <= 9; k++) {
				if (check(r, c, k)) {
					int shift = 1 << k;
					use[0][r] |= shift;
					use[1][c] |= shift;
					use[2][r / 3 * 3 + c / 3] |= shift;
					sudoku[r][c] = k;
					complete(r, c + 1);
					if (complete)
						return;
					sudoku[r][c] = 0;
					use[0][r] &= ~shift;
					use[1][c] &= ~shift;
					use[2][r / 3 * 3 + c / 3] &= ~shift;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = str.charAt(j) - '0';
				if (sudoku[i][j] >= 1 && sudoku[i][j] <= 9) {
					int shift = 1 << sudoku[i][j];
					use[0][i] |= shift;
					use[1][j] |= shift;
					use[2][i / 3 * 3 + j / 3] |= shift;
				}
			}
		}

		complete(0, 0);

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}