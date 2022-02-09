package swea.D4;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_D4_1210_Ladder1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[][] deltas = {{ 0, -1 }, { 0, 1 }, { -1, 0 }};

		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			int r = 0, c = 0;

			int[][] ladder = new int[100][100];

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if (ladder[i][j] == 2) {
						r = i;
						c = j;
					}
				}
			}

			while (true) {
				for (int d = 0; d < 3; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];

					if (isIn(nr, nc) && ladder[nr][nc] == 1) {
						ladder[r][c] = 0;
						r = nr;
						c = nc;
						break;
					}
				}
				if (r == 0) {
					sb.append("#" + t + " " + c + "\n");
					break;
				}
			}
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < 100 && nc >= 0 && nc < 100;
	}
}