package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_tree_G2_12912 {

    static class Edge {
        int from;
        int to;
        long cost;

        Edge(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int N;
    static ArrayList<Edge>[] list;
    static Edge[] edges;
    static boolean[] visited;
    static long[] dist;

    public static int dfs(int cur, Edge except) {
        visited[cur] = true;
        int last = cur;
        dist[cur] = 0;
        for(Edge next : list[cur]) {
            if((next.from == except.from && next.to == except.to) || (next.from == except.to && next.to == except.from))
                continue;
            if(!visited[next.to]) {
                visited[next.to] = true;
                int vertex = dfs(next.to, except);
                if(dist[next.to] + next.cost > dist[cur]) {
                    dist[cur] = dist[next.to] + next.cost;
                    last = vertex;
                }
            }
        }
        return last;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        edges = new Edge[N - 1];
        list = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            list[from].add(new Edge(from, to, cost));
            list[to].add(new Edge(to, from, cost));
            edges[i] = new Edge(from, to, cost);
        }

        long MAX = Long.MIN_VALUE;

        for(int i = 0; i < N - 1; i++) {
            Edge cur = edges[i];
            visited = new boolean[N];
            dist = new long[N];

            int a = dfs(cur.from, cur);
            Arrays.fill(visited, false);
            int b = dfs(a, cur);
            Arrays.fill(visited, false);
            int c = dfs(cur.to, cur);
            Arrays.fill(visited, false);
            int d = dfs(c, cur);

            MAX = Math.max(MAX, dist[a] + dist[c] + cur.cost);
        }

        System.out.println(MAX);
    }
}