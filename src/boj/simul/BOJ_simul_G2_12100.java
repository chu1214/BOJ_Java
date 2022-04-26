package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_G2_12100 {

	static int N, max, ans, cur;
	static int[] movement;
	static int[][] board;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] isFixed;
	static boolean isMax = false;

	public static void up(int[][] tboard) {
		isFixed = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (tboard[r][c] == 0)
					continue;
				int or = r;
				int oc = c;
				while (true) {
					int nr = or + dr[0];
					int nc = oc + dc[0];
					if (!isIn(nr, nc) || isFixed[nr][nc] || (tboard[nr][nc] != 0 && (tboard[nr][nc] != tboard[or][oc])))
						break;
					if (tboard[nr][nc] == tboard[or][oc]) {
						tboard[nr][nc] *= 2;
						tboard[or][oc] = 0;
						isFixed[nr][nc] = true;
						if (tboard[nr][nc] > cur) {
							cur = tboard[nr][nc];
						}
						break;
					} else {
						tboard[nr][nc] = tboard[or][oc];
						tboard[or][oc] = 0;
						or = nr;
						oc = nc;
					}
				}
			}
		}
	}

	public static void down(int[][] tboard) {
		isFixed = new boolean[N][N];
		for (int r = N - 1; r >= 0; r--) {
			for (int c = 0; c < N; c++) {
				if (tboard[r][c] == 0)
					continue;
				int or = r;
				int oc = c;
				while (true) {
					int nr = or + dr[1];
					int nc = oc + dc[1];
					if (!isIn(nr, nc) || isFixed[nr][nc] || (tboard[nr][nc] != 0 && (tboard[nr][nc] != tboard[or][oc])))
						break;
					if (tboard[nr][nc] == tboard[or][oc]) {
						tboard[nr][nc] *= 2;
						tboard[or][oc] = 0;
						isFixed[nr][nc] = true;
						if (tboard[nr][nc] > cur) {
							cur = tboard[nr][nc];
						}
						break;
					} else {
						tboard[nr][nc] = tboard[or][oc];
						tboard[or][oc] = 0;
						or = nr;
						oc = nc;
					}
				}
			}
		}
	}

	public static void left(int[][] tboard) {
		isFixed = new boolean[N][N];
		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N; r++) {
				if (tboard[r][c] == 0)
					continue;
				int or = r;
				int oc = c;
				while (true) {
					int nr = or + dr[2];
					int nc = oc + dc[2];
					if (!isIn(nr, nc) || isFixed[nr][nc] || (tboard[nr][nc] != 0 && (tboard[nr][nc] != tboard[or][oc])))
						break;
					if (tboard[nr][nc] == tboard[or][oc]) {
						tboard[nr][nc] *= 2;
						tboard[or][oc] = 0;
						isFixed[nr][nc] = true;
						if (tboard[nr][nc] > cur) {
							cur = tboard[nr][nc];
						}
						break;
					} else {
						tboard[nr][nc] = tboard[or][oc];
						tboard[or][oc] = 0;
						or = nr;
						oc = nc;
					}
				}
			}
		}
	}

	public static void right(int[][] tboard) {
		isFixed = new boolean[N][N];
		for (int c = N - 1; c >= 0; c--) {
			for (int r = 0; r < N; r++) {
				if (tboard[r][c] == 0)
					continue;
				int or = r;
				int oc = c;
				while (true) {
					int nr = or + dr[3];
					int nc = oc + dc[3];
					if (!isIn(nr, nc) || isFixed[nr][nc] || (tboard[nr][nc] != 0 && (tboard[nr][nc] != tboard[or][oc])))
						break;
					if (tboard[nr][nc] == tboard[or][oc]) {
						tboard[nr][nc] *= 2;
						tboard[or][oc] = 0;
						isFixed[nr][nc] = true;
						if (tboard[nr][nc] > cur) {
							cur = tboard[nr][nc];
						}
						break;
					} else {
						tboard[nr][nc] = tboard[or][oc];
						tboard[or][oc] = 0;
						or = nr;
						oc = nc;
					}
				}
			}
		}
	}

	public static void check(int[][] tboard, int dir) {
		switch (dir) {
		case 0:
			up(tboard);
			break;
		case 1:
			down(tboard);
			break;
		case 2:
			left(tboard);
			break;
		case 3:
			right(tboard);
			break;
		}
	}

	public static void move(int cnt) {
		if (cnt == 5) {
			int[][] temp = new int[N][N];
			cur = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp[i][j] = board[i][j];
				}
			}

			for (int i = 0; i < 5; i++) {
				if (Math.max(cur, max) * Math.pow(2, (5 - i)) < ans)
					return;
				if (ans == max * 32) {
					isMax = true;
					return;
				}
				check(temp, movement[i]);
			}
			ans = Math.max(ans, cur);
			return;
		}

		for (int i = 0; i < 4; i++) {
			movement[cnt] = i;
			move(cnt + 1);
			if (isMax)
				return;
		}
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		movement = new int[5];
		max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, board[i][j]);
			}
		}

		ans = max;
		move(0);

		System.out.println(ans);
	}
}