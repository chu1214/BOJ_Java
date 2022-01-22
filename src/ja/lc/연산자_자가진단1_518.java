package ja.lc;

import java.util.Scanner;

public class 연산자_자가진단1_518 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			sum += scanner.nextInt();
		}
		int avg = sum / 3;
		
		System.out.printf("sum : %d%navg : %d", sum, avg);
	}

}