package ja.lc;

import java.util.Scanner;

public class 연산자_자가진단7_524 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		boolean c = (num1 != 0) && (num2 != 0);
		boolean d = (num1 != 0) || (num2 != 0);
		System.out.println(c + " " + d);
	}
}