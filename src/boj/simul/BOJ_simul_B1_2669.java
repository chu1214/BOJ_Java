package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_B1_2669 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cnt = 0;
		int[][] board = new int[101][101];

		for(int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			for(int i = x; i < p; i++) {
				for(int j = y; j < q; j++) {
					board[i][j] = 1;
				}
			}
		}
		
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				if(board[i][j] == 1) cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}