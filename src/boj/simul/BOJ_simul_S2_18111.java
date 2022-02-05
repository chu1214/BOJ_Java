package boj.simul;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_simul_S2_18111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int time = Integer.MAX_VALUE;
		int height = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] field = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if(min > field[i][j]) min = field[i][j];
				if(max < field[i][j]) max = field[i][j];
			}
		}
		
		for(int x = min; x <= max; x++) {
			int timer = 0;
			int block = B;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(field[i][j] > x) {
						timer += (field[i][j] - x) * 2;
						block += field[i][j] - x;
					} else if(field[i][j] < x) {
						timer += x - field[i][j];
						block -= x - field[i][j];
					} 
				}
			}
			if(block >= 0 && time >= timer) {
				time = timer;
				height = x;
			}
		}	
		System.out.println(time + " " + height);
	}
}