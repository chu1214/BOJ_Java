package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_tree_G1_19581 {

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
    static boolean[] visited;
    static long[] dist;

    public static int dfs(int cur, int except) {
        visited[cur] = true;
        int last = cur;
        dist[cur] = 0;
        for(Edge next : list[cur]) {
            if(next.to == except) continue;
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

        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            list[from].add(new Edge(from, to, cost));
            list[to].add(new Edge(to, from, cost));
        }

        visited = new boolean[N+1];
        dist = new long[N+1];

        int a = dfs(1, -1);
        Arrays.fill(visited, false);
        int b = dfs(a, -1);

        visited = new boolean[N+1];
        dist = new long[N+1];

        int c = dfs(a, b);

        visited = new boolean[N+1];
        int d = dfs(b, a);


        long max = Math.max(dist[a], dist[b]);

        System.out.println(max);
    }
}