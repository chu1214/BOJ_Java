package boj.segtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_segtree_G1_2042 {

	static int N, M, K;

	static class SegmentTree {
		private long[] tree;

		SegmentTree(int n) {
			tree = new long[4 * n];
		}

		long init(long[] arr, int node, int start, int end) {
			if (start == end) {
				return tree[node] = arr[start];
			} else {
				return tree[node] = init(arr, node * 2, start, (start + end) / 2)
						+ init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
			}
		}

		long sum(int node, int start, int end, int left, long right) {
			if (end < left || right < start) {
				return 0;
			} else if (left <= start && end <= right) {
				return tree[node];
			} else {
				return sum(node * 2, start, (start + end) / 2, left, right)
						+ sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
			}
		}

		void update(int node, int start, int end, int index, long dif) {
			if (end < index || start > index) {
				return;
			} else {
				tree[node] = tree[node] + dif;

				if (start != end) {
					update(node * 2, start, (start + end) / 2, index, dif);
					update(node * 2 + 1, (start + end) / 2 + 1, end, index, dif);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		SegmentTree segtree = new SegmentTree(N + 1);

		long[] arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			long num = Long.parseLong(br.readLine());
			arr[i] = num;
		}

		segtree.init(arr, 1, 1, N);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				long dif = c - arr[b];
				segtree.update(1, 1, N, b, dif);
				arr[b] = c;
			} else if (a == 2) {
				sb.append(segtree.sum(1, 1, N, b, c) + "\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}