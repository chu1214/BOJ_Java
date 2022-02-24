package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_dijkstra_G5_17396 {

	static class Node implements Comparable<Node> {
		int no;
		long cost;

		public Node(int no, long cost) {
			super();
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
	}
	
	static final long INF = 30000000001L;
	static int N, M;
	static long[] minTime;
	static int[] sight;
	static boolean[] visited;
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		minTime = new long[N];
		sight = new int[N];
		visited = new boolean[N];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			sight[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(minTime, INF);
		minTime[0] = 0;
		pq.offer(new Node(0, 0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			
			if(visited[curNode.no]) continue;
			
			for(int i = 0; i < list[curNode.no].size(); i++) {
				Node nextNode = list[curNode.no].get(i);
				if(nextNode.no != N - 1 && sight[nextNode.no] == 1) continue;
				if(minTime[nextNode.no] > minTime[curNode.no] + nextNode.cost) {
					minTime[nextNode.no] = minTime[curNode.no] + nextNode.cost;
					pq.offer(new Node(nextNode.no, minTime[nextNode.no]));
				}
			}
			visited[curNode.no] = true;
		}		
		if(minTime[N - 1] == INF) {
			System.out.println(-1);
		} else {
			System.out.println(minTime[N - 1]);
		}
	}
}