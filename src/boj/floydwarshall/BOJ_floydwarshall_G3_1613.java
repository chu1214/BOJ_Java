package boj.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_floydwarshall_G3_1613 {

	static int N, K, S;
	static int[][] event;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		event = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			event[a][b] = -1;
			event[b][a] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (k == i)
					continue;
				for (int j = 1; j <= N; j++) {
					if (k == j || i == j)
						continue;
					if (event[i][k] == 1 && event[k][j] == 1) {
						event[i][j] = 1;
					} else if (event[i][k] == -1 && event[k][j] == -1) {
						event[i][j] = -1;
					}
				}
			}
		}

		S = Integer.parseInt(br.readLine());

		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(event[a][b] + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

}