package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_B5_10430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		sb.append((A + B) % C + "\n");
		sb.append(((A % C) + (B % C)) % C + "\n");
		sb.append((A * B) % C + "\n");
		sb.append(((A % C) * (B % C)) % C);

		System.out.println(sb.toString());
	}
}