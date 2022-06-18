package free;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static boolean isP(int n) {
		long a = 10;

		while (n / a != 0) {
			a *= 10;
		}

		a /= 10;
		long b = 10;

		while (a >= b) {
			if ((n / a) % 10 != (n % b) / (b / 10)) {
				return false;
			}
			a /= 10;
			b *= 10;
		}

		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(isP(n));

	}

}
