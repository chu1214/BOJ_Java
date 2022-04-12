package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_5604_구간합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			long[] count = new long[10];
			long unit = 1;

			while (A <= B) {
				while (((A % 10) != 0) && (A <= B)) {
					long temp = A;
					while (temp != 0) {
						count[(int) (temp % 10)] += unit;
						temp /= 10;
					}
					A++;
				}
				if (A > B)
					break;
				while (((B % 10) != 9) && (A <= B)) {
					long temp = B;
					while (temp != 0) {
						count[(int) (temp % 10)] += unit;
						temp /= 10;
					}
					B--;
				}

				if (A > B)
					break;

				long sum = (B / 10 - A / 10 + 1) * unit;
				for (int i = 0; i <= 9; i++) {
					count[i] += sum;
				}

				A /= 10;
				B /= 10;
				unit *= 10;
			}
			long ans = 0;
			for (int i = 0; i <= 9; i++) {
				ans += count[i] * i;
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}