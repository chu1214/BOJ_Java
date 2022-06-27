package boj.segtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_segtree_P5_2243 {

    static int N;

    static class SegmentTree {
        int[] tree;

        SegmentTree(int n) {
            tree = new int[4 * n];
        }

        int getCandy(int node, int start, int end, int rank) {
            tree[node]--;
            if (start == end) {
                return start;
            } else {
                if (rank <= tree[node * 2]) {
                    return getCandy(node * 2, start, (start + end) / 2, rank);
                }
                rank -= tree[node * 2];
                if (rank <= tree[node * 2 + 1]) {
                    return getCandy(node * 2 + 1, (start + end) / 2 + 1, end, rank);
                }
            }
            return 0;
        }

        void update(int node, int start, int end, int index, int diff) {
            if(index < start || index > end) {
                return;
            } else {
                tree[node] += diff;
                if(start != end) {
                    update(node * 2, start, (start + end) / 2, index, diff);
                    update(node * 2 + 1, (start + end) / 2 + 1, end , index, diff);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        SegmentTree seg = new SegmentTree(1000001);

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            if(A == 1) {
                int B = Integer.parseInt(st.nextToken());
                sb.append(seg.getCandy(1, 1, 1000000, B) + "\n");
            } else {
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                seg.update(1, 1, 1000000, B, C);
            }
        }
        System.out.println(sb.toString());
    }
}
