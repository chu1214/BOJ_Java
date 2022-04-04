package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기 {

	static class Core {
		int r, c;

		public Core(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int T, N, maxCore, minLength;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Core> cores;

	static void dfs(int cnt, int num, int len) {
		if (maxCore > cores.size() - cnt + num)
			return;

		if (cnt == cores.size()) {
			if (num > maxCore) {
				maxCore = num;
				minLength = len;
			} else if (num == maxCore) {
				minLength = Math.min(minLength, len);
			}
			return;
		}

		Core core = cores.get(cnt);

		int r = core.r;
		int c = core.c;

		for (int d = 0; d < 4; d++) {
			int pr = r;
			int pc = c;
			int nr, nc;
			int length = 0;
			while (true) {
				nr = pr + dr[d];
				nc = pc + dc[d];
				if (!isIn(nr, nc)) {
					break;
				} else if (map[nr][nc] == 1 || map[nr][nc] == 2) {
					length = 0;
					break;
				}
				length++;
				pr = nr;
				pc = nc;
			}
			if (length == 0) {
				dfs(cnt + 1, num, len);
			} else {
				for (int i = 1; i <= length; i++) {
					map[r + dr[d] * i][c + dc[d] * i] = 2;
				}
				dfs(cnt + 1, num + 1, len + length);
				for (int i = 1; i <= length; i++) {
					map[r + dr[d] * i][c + dc[d] * i] = 0;
				}
			}
		}
	}

	static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			cores = new ArrayList<>();
			maxCore = 0;
			minLength = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i >= 1 && i <= N - 2 && j >= 1 && j <= N - 2) {
							cores.add(new Core(i, j));
						} else {
							maxCore++;
						}
					}
				}
			}
			dfs(0, maxCore, 0);

			sb.append("#" + t + " " + minLength + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
