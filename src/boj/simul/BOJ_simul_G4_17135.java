package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_G4_17135 {

	static int N, M, D, ans = Integer.MIN_VALUE;
	static int[][] castle;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static boolean isFound;
	static boolean[] isSet;
	static boolean[][] visited;

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr <= N && nc >= 0 && nc < M;
	}

	public static void findTarget(int r, int c, int[][] map, int limit, int cnt) {
		if (cnt == limit)
			return;

		for (int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!isIn(nr, nc) || visited[nr][nc])
				continue;
			if (map[nr][nc] == 1 || map[nr][nc] == 3) {
				map[nr][nc] = 3;
				isFound = true;
				return;
			} else {
				visited[nr][nc] = true;
				findTarget(nr, nc, map, limit, cnt + 1);
				if (isFound)
					return;
				visited[nr][nc] = false;
			}
		}
	}

	public static void defense(int[][] map, int monster) {
		int sum = 0;
		while (monster > 0) {
			for (int i = 0; i < M; i++) {
				if (map[N][i] == 2) {
					visited = new boolean[N + 1][M];
					isFound = false;
					for (int j = 1; j <= D; j++) {
						findTarget(N, i, map, j, 0);
						if (isFound)
							break;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 3) {
						map[i][j] = 0;
						monster--;
						sum++;
					}
				}
			}

			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if (i != N - 1) {
						map[i + 1][j] = map[i][j];
						if (i == 0)
							map[i][j] = 0;
					} else {
						if (map[i][j] == 1) {
							map[i][j] = 0;
							monster--;
						}
					}
				}
			}
		}

		if (ans < sum)
			ans = sum;
	}

	public static void setArcher(int cnt, int start) {
		if (cnt == 3) {
			int[][] map = new int[N + 1][M];
			int monster = 0;
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = castle[i][j];
					if (map[i][j] == 1)
						monster++;
				}
			}
			defense(map, monster);
			return;
		}

		for (int i = start; i < M; i++) {
			if (!isSet[i]) {
				isSet[i] = true;
				castle[N][i] = 2;
				setArcher(cnt + 1, i + 1);
				isSet[i] = false;
				castle[N][i] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		castle = new int[N + 1][M];
		isSet = new boolean[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		setArcher(0, 0);

		System.out.println(ans);
	}
}