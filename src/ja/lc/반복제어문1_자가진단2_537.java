package ja.lc;

import java.util.Scanner;

public class 반복제어문1_자가진단2_537 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int cnt = 1;
		int sum = 0;
		while(cnt <= num) {
			sum += cnt;
			cnt++;
		}
		System.out.println(sum);
	}
}
