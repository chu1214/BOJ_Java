package swea.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class contest_01_아기상어의엄마찾아삼만리 {

	static class Net {
		int r, c, d, p;

		public Net(int r, int c, int d, int p) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.p = p;
		}
	}

	static int T, N, M, K;
	static int[] baby, mom;
	static int[][] map;
	static ArrayList<Net> nets;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			baby = new int[2];
			mom = new int[2];

			st = new StringTokenizer(br.readLine());
			baby[0] = Integer.parseInt(st.nextToken());
			baby[1] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			mom[0] = Integer.parseInt(st.nextToken());
			mom[1] = Integer.parseInt(st.nextToken());

			nets = new ArrayList<>();
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());

				nets.add(new Net(r, c, d, p));
			}

			map = new int[N + 1][N + 1];

			for (int m = 0; m < M; m++) {
				Net cur = nets.get(m);
				int startR = cur.r - cur.d;
				int startC = cur.c;
				for (int i = 0; i <= cur.d; i++) {
					if (startR + i < 1 && startR + i > N)
						continue;

				}
			}
		}

	}

}
