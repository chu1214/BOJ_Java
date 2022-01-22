package ja.lc;

import java.util.Scanner;

public class 반복제어문1_자가진단5_540 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		while(true) {
			num = scan.nextInt();
			if(num == -1) break;
			else if (num % 3 == 0) {
				System.out.println(num / 3);
			}
		}
	}
}