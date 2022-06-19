package boj.segtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_segtree_G1_2357 {

	static int N, M, min, max;
	static int[] arr;

	static class SegmentTree {
		int[] tree;

		SegmentTree(int n) {
			tree = new int[4 * n];
		}

		int minTree(int[] arr, int node, int start, int end) {
			if (start == end) {
				return tree[node] = arr[start];
			} else {
				return tree[node] = Math.min(minTree(arr, node * 2, start, (start + end) / 2),
						minTree(arr, node * 2 + 1, (start + end) / 2 + 1, end));
			}
		}

		int maxTree(int[] arr, int node, int start, int end) {
			if (start == end) {
				return tree[node] = arr[start];
			} else {
				return tree[node] = Math.max(maxTree(arr, node * 2, start, (start + end) / 2),
						maxTree(arr, node * 2 + 1, (start + end) / 2 + 1, end));
			}
		}

		int findMin(int node, int start, int end, int left, int right) {
			if (end < left || right < start) {
				return Integer.MAX_VALUE;
			} else if (left <= start && end <= right) {
				return tree[node];
			} else {
				return Math.min(findMin(node * 2, start, (start + end) / 2, left, right),
						findMin(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
			}
		}

		int findMax(int node, int start, int end, int left, int right) {
			if (end < left || right < start) {
				return Integer.MIN_VALUE;
			} else if (left <= start && end <= right) {
				return tree[node];
			} else {
				return Math.max(findMax(node * 2, start, (start + end) / 2, left, right),
						findMax(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		SegmentTree minTree = new SegmentTree(N + 1);
		SegmentTree maxTree = new SegmentTree(N + 1);

		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		minTree.minTree(arr, 1, 1, N);
		maxTree.maxTree(arr, 1, 1, N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(minTree.findMin(1, 1, N, a, b) + " " + maxTree.findMax(1, 1, N, a, b) + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}