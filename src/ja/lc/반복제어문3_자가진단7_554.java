package ja.lc;

import java.util.Scanner;

public class 반복제어문3_자가진단7_554 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int a = 1;
		char b = 'A';
		for(int i = 0; i < num; i++) {
			for(int j = num - i; j > 0; j--) {
				System.out.print(a++ + " ");
			}
			for(int j = 0; j <= i; j++) {
				System.out.print(b++ + " ");
			}
			System.out.println();
		}
	}
}