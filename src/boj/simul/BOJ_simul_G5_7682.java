package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_simul_G5_7682 {

	static char[][] board;
	static boolean valid, bingo;
	static int[] dr = { -1, 0, 1, 1 };
	static int[] dc = { 1, 1, 1, 0 };
	static int o, x;

	public static void check(int ver, char[][] board) {
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if ((r == 0 || c == 0) && board[r][c] != '.') {
					for (int d = 0; d < 4; d++) {
						int or = r;
						int oc = c;
						int cnt = 1;
						while (true) {
							int nr = or + dr[d];
							int nc = oc + dc[d];
							if (!isIn(nr, nc) || board[or][oc] != board[nr][nc])
								break;
							if (board[or][oc] == board[nr][nc]) {
								cnt++;
								or = nr;
								oc = nc;
							}
							if (cnt == 3) {
								if (ver == 0 && ((x - o == 1 && board[nr][nc] == 'X')
										|| (x - o == 0 && board[nr][nc] == 'O'))) {
									bingo = true;
								} else {
									bingo = true;
									valid = false;
									return;
								}
							}
						}
					}
				}
			}
		}
		if (ver == 0 && !bingo) {
			valid = false;
			return;
		} else
			return;
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < 3 && nc >= 0 && nc < 3;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str;

		while (!(str = br.readLine()).equals("end")) {
			valid = true;
			bingo = false;
			board = new char[3][3];
			o = 0;
			x = 0;

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					board[i][j] = str.charAt(i * 3 + j);
					if (board[i][j] == 'O')
						o++;
					else if (board[i][j] == 'X')
						x++;
				}
			}

			if ((x - o > 1 || x - o < 0) || (o < 3 && x < 3))
				valid = false;
			else {
				check(0, board);
				if (valid) {
					int sum = (o + x) % 2;
					for (int r = 0; r < 3; r++) {
						for (int c = 0; c < 3; c++) {
							if ((sum == 0 && board[r][c] == 'o') || (sum == 1 && board[r][c] == 'x')) {
								char temp;
								temp = board[r][c];
								board[r][c] = '.';
								check(1, board);
								board[r][c] = temp;
							}
							if (!valid)
								break;
						}
						if (!valid)
							break;
					}
				}
			}
			if (valid || (!bingo && x == 5 && o == 4))
				sb.append("valid\n");
			else
				sb.append("invalid\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}