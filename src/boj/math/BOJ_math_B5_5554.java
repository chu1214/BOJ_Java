package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_math_B5_5554 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sec = 0;
		int min = 0;

		for (int i = 0; i < 4; i++) {
			sec += Integer.parseInt(br.readLine());
		}

		min = sec / 60;
		sec = sec - (sec / 60) * 60;

		System.out.println(min + "\n" + sec);
	}
}