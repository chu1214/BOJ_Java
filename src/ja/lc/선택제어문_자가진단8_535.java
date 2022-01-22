package ja.lc;

import java.util.Scanner;

public class 선택제어문_자가진단8_535 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double score = scan.nextDouble();
		switch ((int)score) {
			case 4: System.out.println("scholarship");
					break;
			case 3: System.out.println("next semester");
		 			break;
			case 2: System.out.println("seasonal semester");
			 		break;
			default:System.out.println("retake");
		}
	}
}