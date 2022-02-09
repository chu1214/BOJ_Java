package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_recursive_G5_9663 {
	
	static final int Q = 1;
	static final int B = 0;
	static int N;
	static int[][] Board;
	static boolean[][] isSelected;
	static int nQueen = 0;
	static int[][] deltas = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}}; 
	static Queue<Queen> q = new ArrayDeque<>();
	
	public static class Queen {
		int r, c;

		public Queen(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void N_Queen(int cnt) {
		if(cnt == N) {
			if(check()) {
				nQueen++;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						System.out.print(Board[i][j] + " ");
					}
					System.out.println();
				}
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				isSelected[i][j] = true;
				q.offer(new Queen(i, j));
				Board[i][j] = Q;
				if(check()) {
					N_Queen(cnt + 1);
				}
				isSelected[i][j] = false;
				Board[i][j] = B;
			}
		}
		
	}
	
	public static boolean check() {
		while(!q.isEmpty()) {
			Queen cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			for(int d = 0; d < 8; d++) {
				int tempR = r;
				int tempC = c;
				while(true) {
					int nr = tempR + deltas[d][0];
					int nc = tempC + deltas[d][1];
					if(!isIn(nr, nc)) break;
					else {
						if(Board[nr][nc] == 1) return false;
						else {
							tempR = nr;
							tempC = nc;
						}
					}
				}
			}
		}
		return true;
	}
	
	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Board = new int[N][N];
		isSelected = new boolean[N][N];
		
		N_Queen(0);
		
		System.out.println(nQueen);
	}
}