package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_greedy_G3_2457 {

	static class Flower implements Comparable<Flower> {
		int sm, sd, em, ed;
		int s, e;

		public Flower(int sm, int sd, int em, int ed) {
			super();
			this.sm = sm;
			this.sd = sd;
			this.em = em;
			this.ed = ed;
			this.s = sm * 100 + sd;
			this.e = em * 100 + ed;
		}

		@Override
		public int compareTo(Flower o) {
			return Integer.compare(o.e, this.e);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Flower[] flowers = new Flower[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sm = Integer.parseInt(st.nextToken());
			int sd = Integer.parseInt(st.nextToken());
			int em = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
			flowers[i] = new Flower(sm, sd, em, ed);
		}

		int ans = 0;
		int day = 301;
		while (day <= 1130) {
			int max = day;
			for (int i = 0; i < flowers.length; i++) {
				if (flowers[i].s <= day && flowers[i].e > max) {
					max = flowers[i].e;
				}
			}
			if (day == max) {
				ans = 0;
				break;
			}
			ans++;
			day = max;
		}

		System.out.println(ans);
	}
}