package swea.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class contest_03_S571922년도탐사보고서의건 {

	static int T, F, N;
	static int[] hand;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			F = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			hand = new int[N + 1];

			Queue<Integer> q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());

			int total = 0;
			while (st.hasMoreTokens()) {
				int next = Integer.parseInt(st.nextToken());
				q.offer(next);
				hand[next]++;
				total++;
			}

			int ans = 0;
			int cnt = 0;
			boolean out = false;

			for (int i = 1; i <= F; i++) {
				if (q.size() == 1) {
					ans = q.poll();
					break;
				}
				int next = q.poll();
				if (i == F) {
					ans = next;
					break;
				}
				int max = 0;
				for (int j = 0; j < hand.length; j++) {
					max = Math.max(max, hand[j]);
				}

				if (hand[next] == max && !out) {
					hand[next]--;
					out = true;
				} else {
					q.offer(next);
				}
				cnt++;
				if (cnt == total)
					cnt = 0;
				if (cnt == 0) {
					if (out) {
						out = false;
						total--;
					}
				}
			}

			sb.append("#" + t + " " + ans + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());

	}

}
