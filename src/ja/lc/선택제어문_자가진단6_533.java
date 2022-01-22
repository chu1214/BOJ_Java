package ja.lc;

import java.util.Scanner;

public class 선택제어문_자가진단6_533 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char gender = scan.next().charAt(0);
		int age = scan.nextInt();
		
		if(gender == 'M' && age < 18) System.out.println("BOY");
		else if(gender == 'M' && age >= 18) System.out.println("MAN");
		else if(gender == 'F' && age < 18) System.out.println("GIRL");
		else System.out.println("WOMAN");
	}
}
