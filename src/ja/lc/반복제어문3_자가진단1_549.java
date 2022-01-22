package ja.lc;

import java.util.Scanner;

public class 반복제어문3_자가진단1_549 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int sum = 0;
		int cnt = 0;
		int plus = 1;
		while(sum < num) {
			sum += plus;
			cnt++;
			plus += 2;
		}
		System.out.println(cnt + " " + sum);
	}
}