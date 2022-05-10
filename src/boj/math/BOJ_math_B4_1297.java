package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_B4_1297 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		double answer = Math.pow(a, 2) / (Math.pow(b, 2) + Math.pow(c, 2));

		System.out.println((int) Math.sqrt(answer * Math.pow(b, 2)) + " " + (int) Math.sqrt(answer * Math.pow(c, 2)));
	}

}
