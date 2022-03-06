package boj.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_floydwarshall_G4_11404 {
	
	static final int INF = 100000001;
	static int N, M;
	static int[][] distance;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		distance = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			Arrays.fill(distance[i], INF);
		}


		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(distance[a][b] > c) {
				distance[a][b] = c;
			}
		}	
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				for(int k = 1; k <= N; k++) {
					if(distance[j][k] > distance[j][i] + distance[i][k]) {
						distance[j][k] = distance[j][i] + distance[i][k];
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(distance[i][j] == INF || i == j) {
					distance[i][j] = 0;
				}
				sb.append(distance[i][j] + " ");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}