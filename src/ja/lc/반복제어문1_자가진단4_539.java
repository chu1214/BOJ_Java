package ja.lc;

import java.util.Scanner;

public class 반복제어문1_자가진단4_539 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		int cnt = 0;
		int sum = 0;
		double avg;
		while(true) {
			num = scan.nextInt();
			cnt++;
			sum += num;
			if(num >= 100) break;
		}
		avg = (double)sum / cnt;
		System.out.println(sum);
		System.out.println(String.format("%.1f", avg));
	}
}