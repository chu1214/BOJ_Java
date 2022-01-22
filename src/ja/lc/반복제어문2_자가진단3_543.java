package ja.lc;

import java.util.Scanner;

public class 반복제어문2_자가진단3_543 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = 1; i <= num; i++) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}
}