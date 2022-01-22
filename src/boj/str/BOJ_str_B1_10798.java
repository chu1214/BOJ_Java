package boj.str;

import java.util.Scanner;

public class BOJ_str_B1_10798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] word = new char[5][15];

		for (int i = 0; i < 5; i++) {
			String str = sc.nextLine();
			word[i] = str.toCharArray();
		}

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if(i < word[j].length)
					System.out.print(word[j][i]);
			}
		}
	}
}