package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_G5_12865 {

	static class Stuff{
		int weight, value;

		public Stuff(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Stuff[] stuff = new Stuff[N+1];
		int[][] dp = new int[N+1][K + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			stuff[i] = new Stuff(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				if(j >= stuff[i].weight) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stuff[i].weight] + stuff[i].value);
				}
				else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++)
			ans = Math.max(dp[i][j], ans);
		}
		
		System.out.println(ans);
	}
}