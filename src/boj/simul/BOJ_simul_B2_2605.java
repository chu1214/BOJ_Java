package boj.simul;

import java.io.*;
import java.util.*;

public class BOJ_simul_B2_2605 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> line = new LinkedList<>();
		int[] ticket = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			ticket[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			line.add(line.size() - ticket[i], i);	
		}
		
		for(Integer n : line) {
			sb.append(n + " ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}