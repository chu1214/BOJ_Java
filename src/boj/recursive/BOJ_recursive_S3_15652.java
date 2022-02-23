package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_recursive_S3_15652 {

	static int N, M;
	static int[] choosed;
	static StringBuilder sb = new StringBuilder();
	
	public static void combination(int start, int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
					sb.append(choosed[i] + " ");
				}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			choosed[cnt] = i;
			combination(i, cnt + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		choosed = new int[M];
		
		combination(1, 0); 
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}