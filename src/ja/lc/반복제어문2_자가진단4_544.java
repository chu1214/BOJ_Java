package ja.lc;

import java.util.Scanner;

public class 반복제어문2_자가진단4_544 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int sum = 0;
		for(int i = num; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);

	}

}
