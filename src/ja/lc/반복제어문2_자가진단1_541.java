package ja.lc;

import java.util.Scanner;

public class 반복제어문2_자가진단1_541 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char alpha = scan.next().charAt(0);
		
		for(int i = 0; i < 20; i++) {
			System.out.print(alpha);
		}
	}
}