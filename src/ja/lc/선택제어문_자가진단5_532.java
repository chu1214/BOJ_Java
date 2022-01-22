package ja.lc;

import java.util.Scanner;

public class 선택제어문_자가진단5_532 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double num1 = scan.nextDouble();
		double num2 = scan.nextDouble();
		
		if(num1 >= 4.0 && num2 >= 4.0) System.out.println("A");
		else if(num1 >= 3.0 && num2 >= 3.0) System.out.println("B");
		else System.out.println("C");
	}
}
