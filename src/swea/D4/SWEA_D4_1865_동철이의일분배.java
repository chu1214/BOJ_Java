package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_1865_동철이의일분배 {

	static int T, N;
	static double[][] work;
	static boolean[] check;
	static double ans;
	static StringBuilder sb = new StringBuilder();

	public static void working(int cnt, double p) {

		if (cnt == N) {
			if (ans < p) {
				ans = p;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				if (p * work[cnt][i] < ans || p * work[cnt][i] == 0)
					continue;
				check[i] = true;
				working(cnt + 1, p * work[cnt][i]);
				check[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			work = new double[N][N];
			check = new boolean[N];
			ans = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					work[i][j] = Double.parseDouble(st.nextToken()) / 100;
				}
			}

			working(0, 1);
			ans *= 100;
			sb.append("#" + t + " " + String.format("%.6f", ans) + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}