package ja.lc;

import java.util.Scanner;

public class 선택제어문_자가진단1_528 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		System.out.println(num);
		
		if(num < 0) {
			System.out.println("minus");
		}

	}

}
