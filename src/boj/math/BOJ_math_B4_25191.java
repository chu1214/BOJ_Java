package boj.math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_B4_25191 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
		int chicken = Integer.parseInt(re.readLine());

		StringTokenizer token = new StringTokenizer(re.readLine());
		int c = Integer.parseInt(token.nextToken());
		int b = Integer.parseInt(token.nextToken());

		System.out.println(Integer.min(chicken, c / 2 + b));

		re.close();
	}
}