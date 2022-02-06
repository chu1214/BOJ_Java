package boj.math;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_math_B1_11050 {

	static int find(int n, int k) {
		if(n == k || k == 0) return 1;
		return find(n-1, k-1) + find (n-1, k);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(find(N, K));
	}
}