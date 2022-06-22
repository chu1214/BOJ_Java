package boj.segtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_segtree_G1_12837 {

    static int N, Q;
    static long[] arr;

    static class SegmentTree {
        long[] tree;

        SegmentTree (int n) {
            tree = new long[4 * n];
        }

        void add(int node, int start, int end, int index, long value) {
            if(index < start || index > end) {
                return;
            } else {
                tree[node] += value;
                if(start != end) {
                    add(node * 2, start, (start+ end) / 2, index, value);
                    add(node * 2 + 1, (start + end) / 2 + 1, end, index, value);
                }
            }
        }

        long flow(int node, int start, int end, int left, int right) {
            if(left > end || right < start)  {
                return 0;
            } else if(left <= start && end <= right) {
                return tree[node];
            }   else{
                return flow(node * 2, start, (start + end)/ 2, left, right)
                        + flow(node * 2 + 1, (start + end) / 2 + 1 , end, left, right);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        SegmentTree seg = new SegmentTree(N + 1);
        arr = new long[N + 1];

        for(int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if(query == 1) {
                int p = Integer.parseInt(st.nextToken());
                long x = Long.parseLong(st.nextToken());
                seg.add(1, 1, N, p, x);
            } else {
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                sb.append(seg.flow(1, 1, N, p, q) + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
