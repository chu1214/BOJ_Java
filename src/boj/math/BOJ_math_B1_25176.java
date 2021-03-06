package boj.math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_math_B1_25176 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int ans = 1;

		while (N > 0) {
			ans *= N;
			N--;
		}

		System.out.println(ans);

	}

}
