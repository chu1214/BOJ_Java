package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_dfs_G3_1941 {

	static int ans = 0, checkCnt;
	static char[][] seat = new char[5][5];
	static boolean[][] union = new boolean[5][5];
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void check(int r, int c) {
		if (checkCnt == 7) {
			ans++;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (isIn(nr, nc) && union[nr][nc] && !visited[nr][nc]) {
				visited[nr][nc] = true;
				checkCnt++;
				check(nr, nc);
			}
		}
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < 5 && nc >= 0 && nc < 5;
	}

	public static void princess(int r, int c, int cnt, int y) {
		if (y == 4)
			return;

		if (cnt == 7) {
			checkCnt = 1;
			visited = new boolean[5][5];
			boolean isSearched = false;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (union[i][j]) {
						visited[i][j] = true;
						check(i, j);
						visited[i][j] = false;
						isSearched = true;
						break;
					}
				}
				if (isSearched)
					break;
			}
			return;
		}

		for (int i = r; i < 5; i++) {
			if (i != r)
				c = 0;
			for (int j = c; j < 5; j++) {
				if (!union[i][j]) {
					union[i][j] = true;
					if (seat[i][j] == 'Y')
						princess(i, j, cnt + 1, y + 1);
					else
						princess(i, j, cnt + 1, y);
					union[i][j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			seat[i] = br.readLine().toCharArray();
		}

		princess(0, 0, 0, 0);

		System.out.println(ans);
	}
}