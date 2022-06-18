package boj.segtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_segtree_G1_11505 {

	static int N, M, K;
	static final long MOD = 1000000007;
	static long[] arr;

	static class SegmentTree {
		long[] tree;

		SegmentTree(int n) {
			tree = new long[4 * n];
		}

		long init(long[] arr, int node, int start, int end) {
			if (start == end) {
				return tree[node] = arr[start];
			} else {
				return tree[node] = init(arr, node * 2, start, (start + end) / 2)
						* init(arr, node * 2 + 1, (start + end) / 2 + 1, end) % MOD;
			}
		}

		long mul(int node, int start, int end, int left, int right) {
			if (end < left || start > right) {
				return 1;
			} else if (left <= start && end <= right) {
				return tree[node];
			} else {
				return mul(node * 2, start, (start + end) / 2, left, right)
						* mul(node * 2 + 1, (start + end) / 2 + 1, end, left, right) % MOD;
			}
		}

		long update(int node, int start, int end, int index) {
			if (index < start || index > end) {
				return tree[node];
			} else {
				if (start == end) {
					return tree[node] = arr[start];

				} else {
					return tree[node] = update(node * 2, start, (start + end) / 2, index)
							* update(node * 2 + 1, (start + end) / 2 + 1, end, index) % MOD;
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

		arr = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		SegmentTree segTree = new SegmentTree(N + 1);
		segTree.init(arr, 1, 1, N);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				arr[b] = c;
				segTree.update(1, 1, N, b);
			} else {
				sb.append(segTree.mul(1, 1, N, b, c) + "\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}