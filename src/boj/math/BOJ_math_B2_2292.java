package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_math_B2_2292 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int sum = 1;
		int i = 0;
		
		while(true) {
			sum += 6 * i; 
			i++;
			if(N < sum + 1) break;
		}
		System.out.println(i);
	}
}