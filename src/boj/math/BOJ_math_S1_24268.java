package boj.math;

import java.util.Scanner;

public class BOJ_math_S1_24268 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		
		int N = sc.nextInt();
		int d = sc.nextInt();
		
		int limit = (int)Math.pow(d, d) - 1;
		int start = N + 1 > Math.pow(d, d-1) ? N + 1 : (int)Math.pow(d, d-1);
		
		for(int i = start; i <= limit; i++) {
			sb = new StringBuilder();
			int temp = i;
			int[] save = new int[10];
			boolean isSpecial = true;
			
			while(temp != 0) {
				sb.append(temp % d);
				save[temp % d]++;
				temp /= d;
			}
			
			for(int j = 0; j < d; j++) {
				if(save[j] != 1) {
					isSpecial = false;
					break;
				}
			}

			if(isSpecial) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}