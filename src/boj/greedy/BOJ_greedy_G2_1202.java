package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_greedy_G2_1202 {

	static class Jewel implements Comparable<Jewel> {
		int M, V;

		public Jewel(int m, int v) {
			super();
			M = m;
			V = v;
		}

		@Override
		public int compareTo(Jewel o) {
			if (this.M == o.M) {
				return Integer.compare(o.V, this.V);
			}
			return Integer.compare(this.M, o.M);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Jewel[] jewels = new Jewel[N];
		int[] bag = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(m, v);
		}

		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(jewels);
		Arrays.sort(bag);

		long sum = 0L;
		int cnt = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < K; i++) {
			while (cnt < N && jewels[cnt].M <= bag[i]) {
				pq.offer(jewels[cnt++].V);
			}
			if (!pq.isEmpty()) {
				sum += pq.poll();
			}

		}

		System.out.println(sum);
	}
}