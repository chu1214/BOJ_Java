package boj.str;

import java.util.Scanner;

public class BOJ_str_B2_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String nums = sc.next();
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(nums.substring(i, i+1));
		}

		System.out.println(sum);
	}

}