package ja.lc;

import java.util.Scanner;

public class 선택제어문_자가진단2_529 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int height = scan.nextInt();
		int weight = scan.nextInt();
		int obesity = weight + 100 - height;
		System.out.println(obesity);
		if(obesity > 0) {
			System.out.println("Obesity");
		}
	}
}
