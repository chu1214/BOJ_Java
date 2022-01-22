package ja.lc;

import java.util.Scanner;

public class 선택제어문_자가진단9_632 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		int min = (num1 < num2) ? num1 : num2;
		min = (min < num3) ? min : num3;
		System.out.println(min);
	}
}