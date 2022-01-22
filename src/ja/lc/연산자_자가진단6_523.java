package ja.lc;

import java.util.Scanner;

public class 연산자_자가진단6_523 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		System.out.println(num1 + " > " + num2 + " --- " + (num1 > num2 ? 1 : 0));
		System.out.println(num1 + " < " + num2 + " --- " + (num1 < num2 ? 1 : 0));
		System.out.println(num1 + " >= " + num2 + " --- " + (num1 >= num2 ? 1 : 0));
		System.out.println(num1 + " <= " + num2 + " --- " + (num1 <= num2 ? 1 : 0));

	}

}
