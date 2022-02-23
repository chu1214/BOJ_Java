package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOj_simul_G4_17144 {
	
	static int R, C, T, cleanerTop, cleanerBot;
	static int[][] map, deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void diffusion() {
		int[][] diffMap = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] > 0) {
					for(int d = 0; d < 4; d++) {
						int nr = r + deltas[d][0];
						int nc = c + deltas[d][1];
						if(isIn(nr, nc) && map[nr][nc] != -1) {
							diffMap[nr][nc] += map[r][c] / 5;
							diffMap[r][c] -= map[r][c] / 5;
						}
					}
				}
			}
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				map[r][c] += diffMap[r][c];
			}
		}
	}
	
	public static void cleaner() {
		int[][] rotateMap = new int[R][C];
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(r < cleanerTop && c == 0) rotateMap[r+1][c] = map[r][c];
				else if(r > cleanerBot && c == 0) rotateMap[r-1][c] = map[r][c];
				else if(r == cleanerTop && c > 0 && c < C - 1) rotateMap[r][c+1] = map[r][c];
				else if(r == cleanerBot && c > 0 && c < C - 1) rotateMap[r][c+1] = map[r][c];
				else if(r > 0 && r <= cleanerTop && c == C - 1) rotateMap[r-1][c] = map[r][c];
				else if(r < R - 1 && r >= cleanerBot && c == C - 1) rotateMap[r+1][c] = map[r][c];
				else if(r == 0 && c > 0 && c <= C - 1) rotateMap[r][c-1] = map[r][c];
				else if(r == R - 1 && c > 0 && c <= C - 1) rotateMap[r][c-1] = map[r][c];
				else rotateMap[r][c] = map[r][c];
			}
		}
		rotateMap[cleanerTop][0] = -1;
		rotateMap[cleanerBot][0] = -1;
		
		map = rotateMap;
		
	}
	
	public static void sequence() {
		while(T -- > 0) {
			diffusion();
			cleaner();
		}
	}
	
	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C; 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					cleanerBot = i;
				}
			}
		}
		cleanerTop = cleanerBot - 1;
		
		sequence();
		
		int ans = 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] > 0) ans += map[r][c]; 
			}
		}
		System.out.println(ans);
	}
}