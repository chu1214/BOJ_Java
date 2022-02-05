package boj.math;

import java.io.*;
import java.util.*;

public class BOJ_math_B3_4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String str;
		
		while(!(str = br.readLine()).equals("0 0 0")) {
			st = new StringTokenizer(str);
			int[] triangle = new int[3];
			
			for(int i = 0; i < 3; i++) {
				triangle[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(triangle);
			
			String ans = Math.pow(triangle[2], 2) == Math.pow(triangle[1], 2) + Math.pow(triangle[0],2) ? "right" : "wrong";
			sb.append(ans + "\n");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}