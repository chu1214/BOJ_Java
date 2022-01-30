package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_greedy_B1_2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i <= N / 5; i++) {
			int sugar = N;
			int temp = 0;
			
			temp += i;
			sugar -= i * 5;

			temp += sugar / 3;
			sugar -= (sugar / 3) * 3;

			
			if(sugar == 0) {
				ans = ans > temp ? temp : ans;
			}
		}
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(ans);
	}
}