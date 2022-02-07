package boj.stack;

import java.io.*;
import java.util.*;

public class BOJ_stack_G5_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Stack<int[]> ans = new Stack<>();
		int N = Integer.parseInt(br.readLine());
				
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
		
			while(!ans.isEmpty()) {
				if(ans.peek()[0] < num) {
					ans.pop();
				} else {
					sb.append(ans.peek()[1] + " ");
					break;
				}
			}
			if(ans.isEmpty()) {
				sb.append(0 + " ");
			}	
			ans.push(new int[] {num, i + 1});
		}		
		System.out.println(sb.toString());
	}
}