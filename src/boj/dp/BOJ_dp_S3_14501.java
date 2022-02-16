package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_S3_14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int ans = 0;
		
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int pay = Integer.parseInt(st.nextToken());
			if(dp[i] < dp[i - 1]) dp[i] = dp[i - 1];
			if(N >= i + day - 1 && dp[i + day - 1] < dp[i - 1] + pay) {
				dp[i + day - 1] = dp[i - 1] + pay;	
			}	 
		}
		System.out.println(dp[N]);
	}

}
