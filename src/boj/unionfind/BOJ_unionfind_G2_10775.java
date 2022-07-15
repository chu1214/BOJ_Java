package boj.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_unionfind_G2_10775 {

    static int[] parent;

    public static void make(int G, int P) {
        int size = Math.max(G, P);
        parent = new int[size + 1];

        for(int i = 1; i <= G; i++) {
            parent[i] = i;
        }
    }

    public static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int ans = 0;

        make(G, P);

        for(int i = 0; i < P; i++) {
            int p = Integer.parseInt(br.readLine());
            if(find(p) == 0) break;
            ans++;
            union(find(p), find(p) - 1);
        }

        System.out.println(ans);
    }
}