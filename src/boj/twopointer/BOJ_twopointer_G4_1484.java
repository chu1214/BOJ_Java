package boj.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_twopointer_G4_1484 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long G = Long.parseLong(br.readLine());
		boolean able = false;

		for (long i = (long) Math.round(Math.sqrt(G)); i <= 100000; i++) {
			if (Math.sqrt(Math.pow(i, 2) - G) % 1 == 0 && Math.sqrt(Math.pow(i, 2) - G) != 0) {
				able = true;
				sb.append(i + "\n");
			}
		}

		if (!able)
			System.out.println(-1);
		else {
			System.out.println(sb.toString());
		}
	}
}