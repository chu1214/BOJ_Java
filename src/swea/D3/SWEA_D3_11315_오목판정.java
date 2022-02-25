package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_11315_오목판정 {

	static int T, N;
	static char[][] stone;
	static boolean five;
	static int[][] deltas = {{-1, 1}, { 0, 1 }, { 1, 1 }, { 1, 0 } };

	public static void check(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int or = r;
			int oc = c;
			for (int i = 0; i < 4; i++) {
				int nr = or + deltas[d][0];
				int nc = oc + deltas[d][1];
				if (isIn(nr, nc) && stone[nr][nc] == 'o') {
					or = nr;
					oc = nc;
				} else break;
				if(i == 3) {
					five = true;
					return;
				}
			}
		}
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			stone = new char[N][N];
			five = false;

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					stone[i][j] = str.charAt(j);
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(stone[r][c] == 'o')
						check(r, c);
				}
			}
			sb.append("#" + t + " ");
			if (five) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}