package boj.dp;

import java.io.*;

public class BOJ_dp_S3_1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int[] dp = new int[N+1];
		dp[1] = 0;
		
		for(int i = 2; i <= N; i++) {
			if(i % 6 == 0) {
				dp[i] = Math.min(Math.min(dp[i/3], dp[i/2]), dp[i-1]) + 1;
			}
			else if(i % 3 == 0) {
				dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
			}
			else if(i % 2 == 0) {
				dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
			}
			else {
				dp[i] = dp[i-1] + 1;
			}
		}
		
		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
	}
}