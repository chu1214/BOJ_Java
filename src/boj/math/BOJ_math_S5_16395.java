package boj.math;

import java.util.Scanner;

public class BOJ_math_S5_16395 {

	public static int Pascal(int N, int K) {
		if(K == 1 || K == N) return 1;
		return Pascal(N - 1, K - 1) + Pascal(N - 1, K);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		System.out.println(Pascal(N, K));	
	}
}