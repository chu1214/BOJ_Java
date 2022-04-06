package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_simul_G4_2239 {

	static int[][] sudoku = new int[9][9];
	static int[] used = new int[10];
	static boolean complete = false;
	static StringBuilder sb = new StringBuilder();

	public static boolean areaChk(int r, int c, int k) {
		int sr = (r / 3) * 3;
		int sc = (c / 3) * 3;

		for (int i = sr; i < sr + 3; i++) {
			for (int j = sc; j < sc + 3; j++) {
				if (sudoku[i][j] == k)
					return false;
			}
		}
		return true;
	}

	public static boolean colChk(int c, int k) {
		for (int r = 0; r < 9; r++) {
			if (sudoku[r][c] == k)
				return false;
		}
		return true;
	}

	public static boolean rowChk(int r, int k) {
		for (int c = 0; c < 9; c++) {
			if (sudoku[r][c] == k)
				return false;
		}
		return true;
	}

	public static boolean check(int r, int c, int k) {
		if (rowChk(r, k) && colChk(c, k) && areaChk(r, c, k))
			return true;
		return false;
	}

	public static void complete(int r, int c) {
		if (complete)
			return;

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
				if (used[k] != 9 && check(r, c, k)) {
					used[k]++;
					sudoku[r][c] = k;
					complete(r, c + 1);
					sudoku[r][c] = 0;
					used[k]--;
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
					used[sudoku[i][j]]++;
				}
			}
		}

		complete(0, 0);

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}