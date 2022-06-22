package boj.segtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_segtree_G1_5676 {

    static int N, K;
    static int[] arr;

    static class SegmentTree {
        int[] tree;

        SegmentTree(int n) {
            tree = new int[4 * n];
            Arrays.fill(tree, 1);
        }

        int init(int[] arr, int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            } else {
                return tree[node] = init(arr, node * 2, start, (start + end) / 2)
                        * init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
            }
        }

        int C(int node, int start, int end, int index, int diff) {
            if (index < start || index > end) {
                return tree[node];
            } else {
                if (start == end) {
                    return tree[node] = diff;
                } else {
                    return tree[node] = C(node * 2, start, (start + end) / 2, index, diff) *
                            C(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
                }
            }
        }

        int P(int node, int start, int end, int left, int right) {
            if (start > right || end < left) {
                return 1;
            } else if (left <= start && end <= right) {
                return tree[node];
            } else {
                return P(node * 2, start, (start + end) / 2, left, right)
                        * P(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (br.ready()) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            SegmentTree seg = new SegmentTree(N + 1);

            arr = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int n = 1; n <= N; n++) {
                int num = Integer.parseInt(st.nextToken());
                num = Integer.compare(num, 0);
                arr[n] = num;
            }

            seg.init(arr, 1, 1, N);

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                if (command == 'C') {
                    int i = Integer.parseInt(st.nextToken());
                    int V = Integer.parseInt(st.nextToken());
                    int diff = Integer.compare(V, 0);
                    seg.C(1, 1, N, i, diff);
                } else {
                    int i = Integer.parseInt(st.nextToken());
                    int j = Integer.parseInt(st.nextToken());
                    int result = seg.P(1, 1, N, i, j);
                    if (result > 0) {
                        sb.append("+");
                    } else if (result < 0) {
                        sb.append("-");
                    } else {
                        sb.append("0");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}