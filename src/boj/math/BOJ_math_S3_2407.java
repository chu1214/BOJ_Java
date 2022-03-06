package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class BOJ_Math_S3_2407 {

	public static BigDecimal combination(int N, int M) {
		BigDecimal ans = new BigDecimal(1);
		
		for(int i = N; i > N-M; i--) {
			ans = ans.multiply(new BigDecimal(i));
		}
		
		for(int i = M; i > 0; i--) {
			ans = ans.divide(new BigDecimal(i));
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		System.out.println(combination(N,M));

	}

}
