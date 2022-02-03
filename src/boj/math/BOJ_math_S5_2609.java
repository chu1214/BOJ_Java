package boj.math;

import java.util.Scanner;

public class BOJ_math_S5_2609 {

	static int gcd(int a, int b) {
		if(a % b != 0)
			b = gcd(b, a % b);
		
		return b;
	}
	
	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(gcd(a > b ? a : b, a > b ? b : a));
		System.out.println(lcm(a > b ? a : b, a > b ? b : a));
	}
}