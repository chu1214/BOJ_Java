package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_dijkstra_G4_1504 {

	static class Edge implements Comparable<Edge>{
		int node, cost;

		public Edge(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static final int INF = 200000001;
	static int N, E, ans = 0;
	static ArrayList<Edge>[] list;
	static int[][] minCost;
	static boolean[][] visited;
	
	public static int dijkstra(int start, int idx) {
		Arrays.fill(minCost[idx], INF);
		minCost[idx][start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			visited[idx][cur.node] = true;
			for(int i = 0; i < list[cur.node].size(); i++) {
				Edge next = list[cur.node].get(i);
				if(visited[idx][next.node]) continue;
				if(minCost[idx][next.node] > minCost[idx][cur.node] + next.cost) {
					minCost[idx][next.node] = minCost[idx][cur.node] + next.cost;
					pq.offer(new Edge(next.node, minCost[idx][next.node]));
				}
			}
			
		}
		
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b, c));
			list[b].add(new Edge(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int[] v = new int[3];
		v[0] = 1;
		v[1] = Integer.parseInt(st.nextToken());
		v[2] = Integer.parseInt(st.nextToken());
		
		minCost = new int[3][N+1];
		visited = new boolean[3][N+1];
		
		for(int i = 0; i < 3; i++) {
			dijkstra(v[i], i);
		}
		
		ans = Math.min(minCost[0][v[1]] + minCost[1][v[2]] + minCost[2][N], minCost[0][v[2]] + minCost[2][v[1]] + minCost[1][N]);
		if(ans >= INF) ans = -1;
	
		System.out.println(ans);
	}
}