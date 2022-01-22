package ja.lc;

import java.util.Scanner;

public class 연산자_자가진단8_525 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		
		System.out.println(((num1 > num2 && num1 > num3) ? 1 : 0) + " " + ((num1 == num2 && num2 == num3) ? 1 : 0));
		
	}

}
