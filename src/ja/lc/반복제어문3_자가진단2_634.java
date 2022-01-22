package ja.lc;

import java.util.Scanner;

public class 반복제어문3_자가진단2_634 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = 0; i < num; i++) {
			for(int j = i; j >= 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}