package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5644_무선충전 {

	static int[][] deltas = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static int[][] BC;
	static int[] userA, userB;
	static int answer, M, A, C, P;

	public static void charge(int xA, int yA, int xB, int yB, int time) {
		int max = 0;
		boolean[] useA = new boolean[A];
		boolean[] useB = new boolean[A];

		for (int i = 0; i < A; i++) {
			if (BC[i][2] >= Math.abs(xA - BC[i][0]) + Math.abs(yA - BC[i][1])) {
				useA[i] = true;
			}
			for (int j = 0; j < A; j++) {
				if (BC[j][2] >= Math.abs(xB - BC[j][0]) + Math.abs(yB - BC[j][1])) {
					useB[j] = true;
				}
				int chargable = 0;
				if (useA[i])
					chargable += BC[i][3];
				if (useB[j])
					chargable += BC[j][3];
				if (useA[i] && useB[j] && i == j)
					chargable /= 2;
				if (chargable > max)
					max = chargable;
				useB[j] = false;
			}
			useA[i] = false;
		}
		answer += max;

		if (time == M)
			return;

		xA = xA + deltas[userA[time]][0];
		yA = yA + deltas[userA[time]][1];
		xB = xB + deltas[userB[time]][0];
		yB = yB + deltas[userB[time]][1];

		charge(xA, yA, xB, yB, time + 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			answer = 0;

			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			userA = new int[M];
			userB = new int[M];
			BC = new int[A][4];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				userA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				userB[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				BC[i][0] = Integer.parseInt(st.nextToken());
				BC[i][1] = Integer.parseInt(st.nextToken());
				BC[i][2] = Integer.parseInt(st.nextToken());
				BC[i][3] = Integer.parseInt(st.nextToken());
			}

			charge(1, 1, 10, 10, 0);

			sb.append("#" + t + " " + answer + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
