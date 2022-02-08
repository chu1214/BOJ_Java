package boj.recursive;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_recursive_S3_15650 {

	static int N, M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int number : numbers) {
				sb.append(number + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];

		combination(0, 1);
		
		System.out.println(sb.toString());
	}
}