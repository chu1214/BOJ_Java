package boj.segtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_segtree_G1_2268 {

    static int N, M;
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
                        + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
            }
        }

        long sum(int node, int start, int end, int left, long right) {
            if (end < left || start > right) {
                return 0;
            } else if (left <= start && end <= right) {
                return tree[node];
            } else {
                return sum(node * 2, start, (start + end) / 2, left, right)
                        + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
            }
        }

        void update(int node, int start, int end, int index, long diff) {
            if (index < start || end < index) {
                return;
            } else {
                tree[node] += diff;
                if (start != end) {
                    update(node * 2, start, (start + end) / 2, index, diff);
                    update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
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

        SegmentTree seg = new SegmentTree(N + 1);

        arr = new long[N + 1];

        seg.init(arr, 1, 1, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 0) {
                if (b > c) {
                    int temp = b;
                    b = (int) c;
                    c = temp;
                }
                sb.append(seg.sum(1, 1, N, b, c) + "\n");
            } else {
                long diff = c - arr[b];
                arr[b] = c;
                seg.update(1, 1, N, b, diff);
            }
        }
        System.out.println(sb.toString());
    }
}