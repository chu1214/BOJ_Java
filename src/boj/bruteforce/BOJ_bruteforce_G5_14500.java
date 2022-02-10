package boj.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_bruteforce_G5_14500 {

	static int N, M;
	static int[][] score;
	static boolean[][] visited;
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int maxScore = 0;

	public static void makeT(int r, int c, int sum) {
		if(r >= 0 && r < N - 1 && c > 0 && c < M - 1) {
			sum = score[r][c] + score[r][c - 1] + score[r][c + 1] + score[r + 1][c];
			if(sum > maxScore) maxScore = sum;
		}
		if(r > 0 && r < N - 1 && c > 0 && c <= M - 1) {
			sum = score[r][c] + score[r - 1][c] + score[r + 1][c] + score[r][c - 1];
			if(sum > maxScore) maxScore = sum;
		}
		if(r > 0 && r <= N - 1 && c > 0 && c < M - 1) {
			sum = score[r][c] + score[r][c - 1] + score[r][c + 1] + score[r - 1][c];
			if(sum > maxScore) maxScore = sum;
		}
		if(r > 0 && r < N - 1 && c >= 0 && c < M - 1) {
			sum = score[r][c] + score[r - 1][c] + score[r + 1][c] + score[r][c + 1];
			if(sum > maxScore) maxScore = sum;
		}
	}
	
	public static void dfs(int r, int c, int sum, int cnt) {
		if(cnt == 4) {
			if(sum > maxScore) maxScore = sum;
			return;
		}
		
		visited[r][c] = true;		
		for(int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr, nc) && !visited[nr][nc]) {
				dfs(nr, nc, sum + score[nr][nc], cnt + 1);
			}
		}
		visited[r][c] = false;
	}
	
	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		score = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				dfs(i, j, 0, 0);
				makeT(i, j, 0);
			}
		}
		
		System.out.println(maxScore);
	}
}