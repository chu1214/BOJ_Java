package boj.binarysearch;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_binarysearch_S4_10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] posCount = new int[10000001];
		int[] negCount = new int[10000001];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num >= 0) posCount[num]++;
			else negCount[-num]++;
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num >= 0) sb.append(posCount[num] + " ");
			else sb.append(negCount[-num] + " ");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}