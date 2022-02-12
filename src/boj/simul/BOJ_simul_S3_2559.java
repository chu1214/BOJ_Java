package boj.simul;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_simul_S3_2559 {

	static int N, K;
	static int[] temperature;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int ans = Integer.MIN_VALUE;
		
		temperature = new int[K];
		
		st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			if(i >= K) {
				sum -= temperature[i % K];
			}
			temperature[i % K] = Integer.parseInt(st.nextToken());
			sum += temperature[i % K];
			if(i >= K - 1 && sum > ans) 
				ans = sum;
		}
		System.out.println(ans);
	}
}