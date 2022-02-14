package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_bruteforce_B2_3040 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int sum = 0;
		int[] height = new int[9];
		
		for(int i = 0; i < 9; i++) {
			int h = Integer.parseInt(br.readLine());
			height[i] = h;
			sum += h;
		}
		
outer : for(int i = 0; i < 8; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(sum - height[i] - height[j] == 100) {
					height[i] = 0;
					height[j] = 0;
					break outer;
				}
			}
		}
		
		for(int num : height) {
			if(num != 0)
				sb.append(num + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}