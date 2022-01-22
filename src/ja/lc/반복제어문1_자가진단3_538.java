package ja.lc;

import java.util.Scanner;

public class 반복제어문1_자가진단3_538 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
		System.out.print("number? ");
		int num = scan.nextInt();
		if(num == 0) break;
		else if(num > 0) System.out.println("positive integer");
		else System.out.println("negative number");
		}
	}
}