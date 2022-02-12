package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_S4_2477 {

	static int K;
	static int[][] Hexa = new int[6][2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		int maxR = 0, maxC = 0;
		int rIdx = -1, cIdx = -1;
		int size = 0;

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			Hexa[i][0] = Integer.parseInt(st.nextToken());
			Hexa[i][1] = Integer.parseInt(st.nextToken());
			if (Hexa[i][0] == 1 || Hexa[i][0] == 2) {
				if (Hexa[i][1] > maxC) {
					maxC = Hexa[i][1];
					cIdx = i;
				}
			} else {
				if (Hexa[i][1] > maxR) {
					maxR = Hexa[i][1];
					rIdx = i;
				}
			}

			int second;

			if ((rIdx == 0 && cIdx == 5) || (rIdx == 5 && cIdx == 0)) {
				second = 0;
				size = maxR * maxC - Hexa[(second + 2) % 6][1] * Hexa[(second + 3) % 6][1];
			} else {
				second = rIdx > cIdx ? rIdx : cIdx;
				size = maxR * maxC - Hexa[(second + 2) % 6][1] * Hexa[(second + 3) % 6][1];
			}
		}
		System.out.println(size * K);
	}
}