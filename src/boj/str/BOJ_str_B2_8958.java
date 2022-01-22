package boj.str;

import java.util.Scanner;

public class BOJ_str_B2_8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int score = 0;
			int continueCnt = 0;
			String str = sc.next();
			char OX;
			for(int i = 0; i < str.length(); i++) {
				OX = str.charAt(i);
				if(OX == 'O') {
					score+=++continueCnt;
					
				}
				else if(OX == 'X') {
					continueCnt = 0;
				}
			}
			System.out.println(score);
		}
	}
}