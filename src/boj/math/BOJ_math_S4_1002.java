package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_S4_1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			if (x1 == x2 && y1 == y2) {
				if (r1 == r2)
					sb.append(-1);
				else
					sb.append(0);
			} else {
				double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
				int target = r1 + r2;
				if (distance < target) {
					if (distance + r1 == r2 || distance + r2 == r1)
						sb.append(1);
					else if (distance + r1 < r2 || distance + r2 < r1)
						sb.append(0);
					else
						sb.append(2);
				} else if (distance == target)
					sb.append(1);
				else
					sb.append(0);
			}
			if (t != T)
				sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
