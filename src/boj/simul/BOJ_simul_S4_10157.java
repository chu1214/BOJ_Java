package boj.simul;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_simul_S4_10157 {

	static int R, C, K;
	static int[][] Hall;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static boolean isIn(int nr, int nc) {
		return nr >= 1 && nr <= R && nc >= 1 && nc <= C;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		Hall = new int[R + 1][C + 1];

		int r = 1, c = 1, d = 0;

		if (K > R * C) {
			System.out.println(0);
		} else {
			for (int cnt = 1; cnt <= K; cnt++) {
				if (K == 1) {
					System.out.println(1 + " " + 1);
					break;
				}

				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];

				if (isIn(nr, nc) && Hall[nr][nc] != 1) {
					if (cnt == K - 1) {
						System.out.println(nr + " " + nc);
						break;
					}
					Hall[r][c] = 1;
					r = nr;
					c = nc;
				} else {
					d = (d + 1) % 4;
					cnt--;
				}
			}
		}
	}
}