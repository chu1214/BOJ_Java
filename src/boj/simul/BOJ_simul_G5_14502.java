package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_G5_14502 {

	static int N, M, min = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void virus(int r, int c, boolean[][] visited) {
		for(int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 0) {
				map[nr][nc] = 3;
				virus(nr, nc, visited);
			}
		}
	}
	
	public static void setWall(int cnt) {
		boolean[][] visited = new boolean[N][M];
		
		if(cnt == 3) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 2) {
						virus(i, j, visited);
					}
				}
			}
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 2 || map[i][j] == 3) {
						count++;
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 3) {
						map[i][j] = 0;
					}
				}
			}
			if(count < min) min = count;
			return;
		} 
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					setWall(cnt + 1);
					map[i][j] = 0;
				}
			}
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

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		setWall(0);

		System.out.println(N * M - min);
	}
}