package boj.simul;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_simul_G5_16927 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[][] deltas = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int G = Math.min(N, M) / 2;
		
		
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < G; j++) {
				int r = j;
				int c = j;
				
				int temp = arr[r][c];
				
				int d = 0;
				
				while(d < 4) {
					int nr = r - deltas[d][0];
					int nc = c - deltas[d][1];
					
					if(nr >= j && nc >= j && nr < N - j && nc < M - j) {
						arr[r][c] = arr[nr][nc];
						r = nr;
						c = nc;
					}
					else {
						d++;
					}
				}
				arr[j+1][j] = temp;
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}