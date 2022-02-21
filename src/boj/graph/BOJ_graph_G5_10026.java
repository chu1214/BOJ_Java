package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_graph_G5_10026 {
	
	static int N, A = 0, B = 0;
	static char[][] grid;
	static boolean[][] visited;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static int find(int r, int c) {
		visited[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr, nc) && !visited[nr][nc] && grid[r][c] == grid[nr][nc]) {
				find(nr, nc);
			}
		}
		return 1;
	}
	
	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j])
					A += find(i, j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(grid[i][j] == 'G')
					grid[i][j] = 'R';
			}
		}
		
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j])
					B += find(i, j);
			}
		}
		System.out.println(A + " " + B);
	}
}