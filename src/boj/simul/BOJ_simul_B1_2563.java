package boj.simul;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_simul_B1_2563 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] colorPaper = new int[100][100];
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			for(int r = R; r < R + 10; r++) {
				for(int c = C; c < C + 10; c++) {
					colorPaper[r][c] = 1;
				}
			}	
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(colorPaper[i][j] == 1) cnt++;
			}
		}
		System.out.println(cnt);
	}
}