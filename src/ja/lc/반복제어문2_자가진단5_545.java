package ja.lc;

import java.util.Scanner;

public class 반복제어문2_자가진단5_545 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] num = new int[10];
		int mul3 = 0, mul5 = 0;
		for(int i = 0; i < 10 ; i++) {
			num[i] = scan.nextInt();
			if(num[i] % 3 == 0) mul3++;
			if(num[i] % 5 == 0) mul5++;
		}
		System.out.println("Multiples of 3 : " + mul3);
		System.out.println("Multiples of 5 : " + mul5);
	}

}