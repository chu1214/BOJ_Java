package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_dijkstra_G5_14284 {

	static class Node implements Comparable<Node> {
		int node, cost;

		public Node(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		} 
	}
	
	static int N, M, S, T;
	static ArrayList<Node>[] list;
	static int[] distance;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(distance, Integer.MAX_VALUE);
		pq.offer(new Node(S, 0));
		distance[S] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
		
			if(visited[cur.node]) continue;
			if(cur.node == T) break;
			
			for(int i = 0; i < list[cur.node].size(); i++) {
				Node next = list[cur.node].get(i);
				if(distance[next.node] > distance[cur.node] + next.cost) {
					distance[next.node] = distance[cur.node] + next.cost;
					pq.offer(new Node(next.node, distance[next.node]));
				}
			}
			visited[cur.node] = true;
		}
		System.out.println(distance[T]);
	}
}