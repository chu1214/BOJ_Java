package boj.recursive;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_recursive_S1_18428 {
	static int N;
	static char[][] corridor;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static String ans = "NO";
	
	public static void hide(int cnt) {
		if (cnt == 3) {
			if (isCheck()) ans = "YES";
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (corridor[i][j] == 'X') {
					corridor[i][j] = 'O';
					hide(cnt + 1);
					corridor[i][j] = 'X';
				}
			}
		}
	}

	public static boolean isCheck() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (corridor[i][j] == 'T') {
					int r = i;
					int c = j;
					for (int d = 0; d < 4; d++) {
						int tempR = r;
						int tempC = c;
						while (true) {
							int nr = tempR + deltas[d][0];
							int nc = tempC + deltas[d][1];
							if (!isIn(nr, nc))
								break;
							if (corridor[nr][nc] == 'S')
								return false;
							if (corridor[nr][nc] == 'O')
								break;
							if (corridor[nr][nc] == 'X' || corridor[nr][nc] == 'T') {
								tempR = nr;
								tempC = nc;
							}
						}
					}
				}
			}
		}
		return true;
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		corridor = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				corridor[i][j] = st.nextToken().charAt(0);
			}
		}
		hide(0);
		
		System.out.println(ans);
	}
}