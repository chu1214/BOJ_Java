package boj.simul;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_simul_S5_2578 {

	static int[][] Bingo = new int[5][5];
	static int Command;
	static int cnt = 0;
	static int ans = 0;
	
	
	public static void checkCol(int r, int c) {
		for(int i = 0; i < 5; i++) {
			if(Bingo[r][i] != 0) return; 
		}
		cnt++;
	}
	
	public static void checkRow(int r, int c) {
		for(int i = 0; i < 5; i++) {
			if(Bingo[i][c] != 0) return;
		}
		cnt++;
	}
	
	public static void checkLeftCross(int r, int c) {
		for(int i = 0; i < 5; i++) {
			if(Bingo[i][i] != 0) return;
		}
		cnt++;
	}
	
	public static void checkRightCross(int r, int c) {
		for(int i = 0; i < 5; i++) {
			if(Bingo[i][4-i] != 0) return;
		}
		cnt++;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				Bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				Command = Integer.parseInt(st.nextToken());
				for(int r = 0; r < 5; r++) {
					for(int c = 0; c < 5; c++) {
						if(Bingo[r][c] == Command) {
							ans++;
							Bingo[r][c] = 0;
							checkRow(r, c);
							checkCol(r, c);
							if(r == c)
								checkLeftCross(r, c);
							if(r + c == 4)
								checkRightCross(r, c);
							if(cnt >= 3) {
								System.out.println(ans);
								System.exit(0);
							}
						}
					}
				}
			}
		}
	}
}