package boj.recursive;

import java.io.*;
import java.util.*;

public class BOJ_recursive_S3_15655 {

	static int[] inputs, numbers;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int i = 0; i < cnt; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			combination(cnt + 1, i + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inputs = new int[N];
		numbers = new int[M];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(inputs);
		
		combination(0, 0);
		
		System.out.println(sb.toString());
	}
}