package boj.segtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_segtree_P4_16975 {

	static int N, M;
	static long[] arr;

	static class SegmentTree {
		long[] tree;

		SegmentTree(int n) {
			tree = new long[4 * n];
		}

		void sum(int node, int start, int end, int left, int right, long plus) {
			if (end < left || start > right) {
				return;
			} else if (left <= start && end <= right) {
				tree[node] += plus;
				return;
			} else {
				sum(node * 2, start, (start + end) / 2, left, right, plus);
				sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right, plus);
			}
		}

		long find(int node, int start, int end, int index) {
			if (index < start || index > end) {
				return 0;
			} else {
				if (start == end) {
					return tree[node];
				}
				return tree[node] + find(node * 2, start, (start + end) / 2, index)
						+ find(node * 2 + 1, (start + end) / 2 + 1, end, index);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new long[N + 1];
		SegmentTree segTree = new SegmentTree(N + 1);

		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			arr[n] = Long.parseLong(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());

			if (query == 1) {
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				long k = Long.parseLong(st.nextToken());
				segTree.sum(1, 1, N, i, j, k);
			} else {
				int x = Integer.parseInt(st.nextToken());
				sb.append(arr[x] + segTree.find(1, 1, N, x) + "\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}