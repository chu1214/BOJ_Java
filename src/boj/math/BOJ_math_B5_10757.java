package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class BOJ_math_B5_10757 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BigDecimal num1 = new BigDecimal(st.nextToken());
		BigDecimal num2 = new BigDecimal(st.nextToken());

		System.out.println(num1.add(num2));
	}

}
