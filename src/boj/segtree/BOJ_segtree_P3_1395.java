package boj.segtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_segtree_P3_1395 {

    static int N, M;

    static class SegmentTree {
        int[] tree, lazy;

        SegmentTree(int n) {
            tree = new int[4 * n];
            lazy = new int[4 * n];
        }

        void propagate(int node, int start, int end) {
            if (lazy[node] % 2 == 1) {
                if (start != end) {
                    lazy[node * 2] += lazy[node];
                    lazy[node * 2 + 1] += lazy[node];
                }
                tree[node] = (end - start + 1) - tree[node];
                lazy[node] = 0;
            }
        }

        void change(int node, int start, int end, int left, int right) {
            propagate(node, start, end);
            if (left > end || right < start) {
                return;
            } else if (left <= start && end <= right) {
                lazy[node] = 1;
                propagate(node, start, end);
            } else {
                change(node * 2, start, (start + end) / 2, left, right);
                change(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
                tree[node] = tree[node * 2] + tree[node * 2 + 1];
            }
        }

        int check(int node, int start, int end, int left, int right) {
            propagate(node, start, end);
            if (left > end || right < start) {
                return 0;
            } else if (left <= start && end <= right) {
                return tree[node];
            } else {
                return check(node * 2, start, (start + end) / 2, left, right)
                        + check(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
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

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int O = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            if (O == 0) {
                seg.change(1, 1, N, S, T);
            } else {
                sb.append(seg.check(1, 1, N, S, T) + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
