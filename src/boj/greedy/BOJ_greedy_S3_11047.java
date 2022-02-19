package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_greedy_S3_11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		int ans = 0;
		
		for(int i = N-1; i >= 0; i--) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < N; i++) {
			if(K == 0) break;
			if(K / coin[i] > 0) {
				ans += K / coin[i];
				K %= coin[i];
			}
		}
		
		System.out.println(ans);
	}
}