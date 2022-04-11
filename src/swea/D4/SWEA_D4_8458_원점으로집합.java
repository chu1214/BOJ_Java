package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_8458_원점으로집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] dots = new int[N][2];
			boolean isOdd = false;
			boolean cant = false;
			int max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				dots[i][0] = Integer.parseInt(st.nextToken());
				dots[i][1] = Integer.parseInt(st.nextToken());
				int sum = Math.abs(dots[i][0]) + Math.abs(dots[i][1]);
				if (i == 0) {
					if (sum % 2 == 1)
						isOdd = true;
				} else {
					if ((isOdd && sum % 2 == 0) || (!isOdd && sum % 2 == 1)) {
						cant = true;
					}
				}
				if (sum > max)
					max = sum;
			}

			int ans = 0;
			if (cant) {
				ans = -1;
			} else {
				while (max > 0) {
					ans++;
					max -= ans;
				}
				if (Math.abs(max) % 2 == 1) {
					if (ans % 2 == 1) {
						ans += 2;
					} else {
						ans += 1;
					}
				}
			}

			sb.append("#" + t + " " + ans + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}