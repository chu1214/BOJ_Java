package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_S4_18917 {

	static int M;
	static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		M = Integer.parseInt(br.readLine());
		long sum = 0;
		long xor = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			long num;

			switch (query) {
			case 1:
				num = Long.parseLong(st.nextToken());
				sum += num;
				xor ^= num;
				break;
			case 2:
				num = Long.parseLong(st.nextToken());
				sum -= num;
				xor ^= num;
				break;
			case 3:
				sb.append(sum).append('\n');
				break;
			case 4:
				sb.append(xor).append('\n');
				break;
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}