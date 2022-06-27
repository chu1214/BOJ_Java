package boj.segtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_segtree_G1_14428 {

    static int N, M;
    static int[] arr;

    static class SegmentTree {
        int[][] tree;

        SegmentTree(int n) {
            tree = new int[4 * n][2];
            for(int i = 1; i < 4 * n; i++) {
                tree[i][1] = Integer.MAX_VALUE;
            }
        }

        int[] init(int node, int start, int end) {
            if(start == end) {
                tree[node][0] = start;
                tree[node][1] = arr[start];
                return tree[node];
            } else {
                int[] left = init(node * 2, start, (start + end) / 2);
                int[] right = init(node * 2 + 1, (start+ end) / 2 + 1, end);

                if(left[1] <= right[1]) {
                    return tree[node] = left;
                } else {
                    return tree[node] = right;
                }
            }
        }

        int[] change(int node, int start, int end, int index, int value) {
            if(index > end || index < start) {
                return tree[node];
            } else {
                if(start == end) {
                    tree[node][0] = index;
                    tree[node][1] = value;
                    return tree[node];
                }
                else {
                    int[] left = change(node * 2, start, (start + end) / 2, index, value);
                    int[] right = change(node * 2 + 1, (start+ end) / 2 + 1, end, index, value);
                    if(left[1] <= right[1]) {
                        return tree[node] = left;
                    } else {
                        return tree[node] = right;
                    }
                }
            }
        }

        int[] print(int node, int start, int end, int left, int right) {
            if(left > end || right < start) {
                return new int[]{-1 , Integer.MAX_VALUE};
            } else if(left <= start && end <= right) {
                return tree[node];
            } else {
                int[] a = print(node * 2, start, (start + end) / 2, left, right);
                int[] b = print(node * 2 + 1, (start + end) / 2 + 1, end, left, right);

                if(a[1] <= b[1]) {
                    return a;
                } else {
                    return b;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        SegmentTree seg = new SegmentTree(N + 1);

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int n = 1; n <= N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        seg.init(1, 1, N);

        M = Integer.parseInt(br.readLine());
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if(query == 1) {
                int i = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                seg.change(1, 1, N, i, v);
            } else {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                sb.append(seg.print(1, 1, N, i , j)[0] + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
