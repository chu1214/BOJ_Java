package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_B1_14696 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] a = new int[5];
			int numA = Integer.parseInt(st.nextToken());

			for (int j = 0; j < numA; j++) {
				a[Integer.parseInt(st.nextToken())]++;
			}

			st = new StringTokenizer(br.readLine());
			int[] b = new int[5];
			int numB = Integer.parseInt(st.nextToken());

			for (int j = 0; j < numB; j++) {
				b[Integer.parseInt(st.nextToken())]++;
			}

			if (a[4] == b[4]) {
				if (a[3] == b[3]) {
					if (a[2] == b[2]) {
						if (a[1] == b[1]) {
							sb.append("D\n");
						} else {
							sb.append(a[1] > b[1] ? "A\n" : "B\n");
						}
					} else {
						sb.append(a[2] > b[2] ? "A\n" : "B\n");
					}
				} else {
					sb.append(a[3] > b[3] ? "A\n" : "B\n");
				}
			} else {
				sb.append(a[4] > b[4] ? "A\n" : "B\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}