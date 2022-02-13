package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_B1_10163 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[][] board = new int[1001][1001];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			for(int r = x; r < x + p; r++) {
				for(int c = y; c < y + q; c++) {
					board[r][c] = i;
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			int cnt = 0;
			for(int r = 0; r < board.length; r++) {
				for(int c = 0; c < board[r].length; c++) {
					if(board[r][c] == i) cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}