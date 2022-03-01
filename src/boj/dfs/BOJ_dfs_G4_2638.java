package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dfs_G4_2638 {

	static int N, M;
	static int[][] grid;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static boolean check() {
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(grid[n][m] == 1) return false;
			}
		}
		return true;
	}
	
	public static void air(int r, int c) {
		grid[r][c] = 9;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!isIn(nr, nc) || grid[nr][nc] == 1 || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			air(nr, nc);
		}
	}
	
	public static int melt(int r, int c) {
		int cnt = 0;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!isIn(nr, nc)) continue;
			if(grid[nr][nc] == 9) cnt++;
		}
		
		return cnt;
	}
	
	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		grid = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				grid[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while(!check()) {
			visited = new boolean[N][M];
			visited[0][0] = true;
			
			air(0, 0);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(grid[i][j] == 1) {
						if(melt(i, j) >= 2) {
							grid[i][j] = 0;
						}
					}
				}
			}
			
			time++;
		}
		
		System.out.println(time);
	}
}