package ja.lc;

import java.util.Scanner;

public class 선택제어문_자가진단7_534 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char alphabet = scan.next().charAt(0);
		if(alphabet == 'A') System.out.println("Excellent");
		else if(alphabet == 'B') System.out.println("Good");
		else if(alphabet == 'C') System.out.println("Usually");
		else if(alphabet == 'D') System.out.println("Effort");
		else if(alphabet == 'F') System.out.println("Failure");
		else System.out.println("error");
	}
}