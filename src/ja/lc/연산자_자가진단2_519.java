package ja.lc;

import java.util.Scanner;

public class 연산자_자가진단2_519 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt() + 100;
		int num2 = scan.nextInt() % 10;		
		System.out.println(num1 + " " +  num2);
	}

}