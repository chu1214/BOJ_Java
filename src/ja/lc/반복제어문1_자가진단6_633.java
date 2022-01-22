package ja.lc;

import java.util.Scanner;

public class 반복제어문1_자가진단6_633 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		while(true) {
			System.out.println("1. Korea\r\n" 
					+ "2. USA\r\n"
					+ "3. Japan\r\n"
					+ "4. China");
			System.out.print("number? ");
			num = scan.nextInt();
			System.out.println("");
			if(num == 1) System.out.println("Seoul");
			else if(num == 2) System.out.println("Washington");
			else if(num == 3) System.out.println("Tokyo");
			else if(num == 4) System.out.println("Beijing");
			else {
				System.out.println("none");
				break;
			}
			System.out.println("");
		}
	}
}