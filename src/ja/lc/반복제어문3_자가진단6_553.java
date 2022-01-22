package ja.lc;

import java.util.Scanner;

public class 반복제어문3_자가진단6_553 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		char alpha = 65;
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num - i; j++) {
				System.out.print(alpha);
				alpha++;
			}
			System.out.println();
		}
	}
}