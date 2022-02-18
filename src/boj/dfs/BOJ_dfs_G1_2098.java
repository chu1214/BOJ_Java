package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dfs_G1_2098 {

	static int N;
	static int[][] W, dp;
	static final int MAX = 16000001;
	
	public static int dfs(int city, int visited) {
		

		if(visited == (1 << N) - 1) {
			if(W[city][0] == 0) return MAX;
			return W[city][0];
		}
		
		if(dp[city][visited] != MAX) {
			return dp[city][visited];
		}
		
		for(int i = 0; i < N; i++) {
			if((visited & (1 << i)) == 0 && W[city][i] != 0) {
			dp[city][visited] = Math.min(dp[city][visited], dfs(i, visited | (1 << i)) + W[city][i]);
			}
		}
		
		return dp[city][visited];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][(1 << N) - 1];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < (1 << N) - 1; j++) {
				dp[i][j] = MAX;
			}
		}
		int ans = dfs(0, 1);
		
		System.out.println(ans);
	}
}