package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_simul_G5_14502 {

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, max = 0;
	static int[][] map;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[] checkedVirus, checkedLand;
	static boolean[][] visited;
	static ArrayList<Pos> virus = new ArrayList<>();
	static ArrayList<Pos> land = new ArrayList<>();
	
	public static void dfs(int r, int c, boolean[][] visited) {
		for(int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 0) {
				map[nr][nc] = 3;
				visited[nr][nc] = true;
				dfs(nr, nc, visited);
			}
		}
	}
	
	public static void setWall(int cnt, int start) {
		if(cnt == 3) {
			for(int i = 0; i < virus.size(); i++) {
				visited = new boolean[N][M];
				dfs(virus.get(i).r, virus.get(i).c, visited);
			}
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 0) {
						sum++;
					}
					if(map[i][j] == 3) map[i][j] = 0;
				}
			}
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = start; i < land.size(); i++) {
			map[land.get(i).r][land.get(i).c] = 1;
			setWall(cnt + 1, i + 1);
			map[land.get(i).r][land.get(i).c] = 0;
		}
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new Pos(i, j));
				if (map[i][j] == 0)
					land.add(new Pos(i, j));
			}
		}

		checkedVirus = new boolean[virus.size()];
		checkedLand = new boolean[land.size()];

		setWall(0, 0);

		System.out.println(max);
	}
}