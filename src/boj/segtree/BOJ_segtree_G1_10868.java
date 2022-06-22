package boj.segtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_segtree_G1_10868 {

    static int N, M;
    static int[] arr;

    static class SegmentTree {
        int[] tree;

        SegmentTree(int n) {
            tree = new int[4 * n];
        }

        int init(int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            } else {
                return tree[node] = Math.min(init(node * 2, start, (start + end) / 2),
                        init(node * 2 + 1, (start + end) / 2 + 1, end));
            }
        }

        int find(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return Integer.MAX_VALUE;
            } else if (left <= start && end <= right) {
                return tree[node];
            } else {
                return Math.min(find(node * 2, start, (start + end) / 2, left, right),
                        find(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
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

        arr = new int[N + 1];
        for (int n = 1; n <= N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        seg.init(1, 1, N);

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(seg.find(1, 1, N, a, b) + "\n");
        }
        System.out.println(sb.toString());
    }
}