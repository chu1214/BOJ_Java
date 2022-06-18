package swea.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class contest_05_나보다나은우리 {

	static int N, Q;
	static String ANS;
	static boolean[][] list;
	static boolean[] selected;
	static boolean found;

	public static void find(int cnt, int max) {
		if (cnt == max) {
			boolean[] check = new boolean[Q];
			for (int i = 0; i < selected.length; i++) {
				if (selected[i]) {
					for (int j = 0; j < Q; j++) {
						if (list[i][j]) {
							check[j] = true;
						}
					}
				}
			}
			for (int i = 0; i < check.length; i++) {
				if (!check[i]) {
					return;
				}
			}
			System.out.println(max);
			found = true;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				find(cnt + 1, max);
				if (found)
					return;
				selected[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (!br.ready()) {
			N = Integer.parseInt(br.readLine());
			ANS = br.readLine();
			Q = ANS.length();

			list = new boolean[N][Q];
			selected = new boolean[N];

			for (int i = 0; i < N; i++) {
				String ans = br.readLine();
				for (int j = 0; j < Q; j++) {
					if (ans.charAt(j) == ANS.charAt(j))
						list[i][j] = true;
					else
						list[i][j] = false;
				}
			}

			found = false;
			for (int i = 1; i <= N; i++) {
				find(0, i);
				if (found)
					break;
			}
			if (!found) {
				System.out.println(-1);
			}
			try {
				br.readLine();
			} catch (Exception e) {

			}
		}
	}
}
