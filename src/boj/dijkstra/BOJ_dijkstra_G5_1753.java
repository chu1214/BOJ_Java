package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_dijkstra_G5_1753 {

	static int V, E, K;
	static int[] minEdge;
	static ArrayList<Node>[] list;

	static class Node implements Comparable<Node> {
		int no;
		int cost;

		public Node(int no, int cost) {
			super();
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		list = new ArrayList[V + 1];
		minEdge = new int[V + 1];
		
		for(int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}


		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, c));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(minEdge, 100000000);
		minEdge[K] = 0;
		pq.offer(new Node(K, 0));

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();

			if(minEdge[curNode.no] >= curNode.cost) {
				for (int i = 0; i < list[curNode.no].size(); i++) {
					Node nextNode = list[curNode.no].get(i);
					if(minEdge[nextNode.no] > curNode.cost + nextNode.cost) {
						minEdge[nextNode.no] = curNode.cost + nextNode.cost;
						pq.add(new Node(nextNode.no, minEdge[nextNode.no]));
					}
				}
			}
			
		}
		for (int i = 1; i <= V; i++) {
			if (minEdge[i] > 9999999 ) {
				sb.append("INF\n");
			} else {
				sb.append(minEdge[i] + "\n");
			}
		}

		System.out.println(sb.toString());
	}
}