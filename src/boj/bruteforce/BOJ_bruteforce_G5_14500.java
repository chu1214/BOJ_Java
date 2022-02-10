package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_bruteforce_G5_14500 {

	static int N, M;
	static int score[][];
	static int maxScore = 0;
	static int currentScore = 0;
	
	public static void make(int cnt, int r, int c) {
		currentScore += score[r][c];
		int temp = score[r][c];
		score[r][c] = 0;
		
		if(cnt == 4) {
			if(maxScore < currentScore) {
				maxScore = currentScore;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						System.out.print(score[i][j] + " ");
					}
					System.out.println();
				}
			}
			currentScore = 0;
			score[r][c] = temp;
			currentScore -= score[r][c];
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(Math.abs((r + c) - (i + j)) == 1 && score[i][j] != 0) {
					make(cnt + 1, i, j);
				}
			}
		}
		score[r][c] = temp;
		currentScore -= score[r][c];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		score = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				make(0, i, j);
			}
		}
		
		System.out.println(maxScore);
	}
}