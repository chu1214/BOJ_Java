package ja.lc;

import java.util.Scanner;

public class 반복제어문2_자가진단6_546 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int classNum = scan.nextInt();
		int[] score = new int[classNum];
		int sum = 0;
		double avg;
		for(int i = 0; i < classNum; i++) {
			score[i] = scan.nextInt();
			sum += score[i];
		}
		avg = (double)sum / classNum;
		System.out.println("avg : " + String.format("%.1f", avg));
		if(avg >= 80) System.out.println("pass");
		else System.out.println("fail");
	}

}
