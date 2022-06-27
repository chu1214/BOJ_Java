package boj.segtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_segtree_G1_18436 {
    static int N, M;
    static int[] arr;

    static class SegmentTree {
        int[][] tree;

        SegmentTree(int n) {
            tree = new int[4 * n][2];
        }

        int[] init(int node, int start, int end) {
            if(start == end) {
                if(arr[start] % 2 == 0) {
                    tree[node][0] = 1;
                } else {
                    tree[node][1] = 1;
                }
            } else {
                int[] left = init(node * 2, start, (start + end) / 2);
                int[] right = init(node * 2 + 1, (start + end) / 2 + 1, end);

                tree[node][0] = left[0] + right[0];
                tree[node][1] = left[1] + right[1];
            }
            return tree[node];
        }

        int[] change(int node, int start, int end, int index, int value) {
            if(index > end || index < start) {
                return tree[node];
            } else {
                if(start == end) {
                    if(value % 2 == 0) {
                        tree[node][0] = 1;
                        tree[node][1] = 0;
                    } else {
                        tree[node][0] = 0;
                        tree[node][1] = 1;
                    }
                }
                else {
                    int[] left = change(node * 2, start, (start + end) / 2, index, value);
                    int[] right = change(node * 2 + 1, (start + end) / 2 + 1, end, index, value);

                    tree[node][0] = left[0] + right[0];
                    tree[node][1] = left[1] + right[1];

                }
                return tree[node];
            }
        }

        int[] print(int node, int start, int end, int left, int right) {
            if(left > end || right < start) {
                return new int[]{0, 0};
            } else if(left <= start && end <= right) {
                return tree[node];
            } else {
                int[] l = print(node * 2, start, (start + end) / 2, left, right);
                int[] r = print(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
                return new int[] {l[0] + r[0], l[1] + r[1]};
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
                int x = Integer.parseInt(st.nextToken());
                seg.change(1, 1, N, i, x);
            } else if(query == 2){
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                sb.append(seg.print(1, 1, N, l , r)[0] + "\n");
            } else{
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                sb.append(seg.print(1, 1, N, l , r)[1] + "\n");
            }

        }
        System.out.println(sb.toString());
    }
}
