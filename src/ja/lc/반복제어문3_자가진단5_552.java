package ja.lc;

import java.util.Scanner;

public class 반복제어문3_자가진단5_552 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < i; j++ ) {
				System.out.print(" ");
			}
			for(int k = num - i; k > 0; k--) {
				System.out.print("*");
			}
			for(int l = num - i - 1; l > 0; l--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}