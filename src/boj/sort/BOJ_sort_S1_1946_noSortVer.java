package boj.sort;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_sort_S1_1946_noSortVer {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] score = new int[N + 1];
			int index;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				index = Integer.parseInt(st.nextToken());
				score[index] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			int curScore = Integer.MAX_VALUE;
			
			for(int i = 1; i < N + 1; i++) {
				if(curScore > score[i]) {
					curScore = score[i];
					cnt++;
				}
			}
			
			sb.append(cnt + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}