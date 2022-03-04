package boj.bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_bellmanford_G3_1865 {

	static class Edge {
		int next, time;

		public Edge(int next, int time) {
			super();
			this.next = next;
			this.time = time;
		}
	}
	
	static final int INF = 1000000000;
	static int T, N, M, W;
	static int[] distance;
	static ArrayList<Edge>[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[N+1];
			distance = new int[N+1];
			
			for(int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M + W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				if(i < M) {
				list[S].add(new Edge(E, T));
				list[E].add(new Edge(S, T));
				} else{
					list[S].add(new Edge(E, -T));
				}
			}
			
			Arrays.fill(distance, INF);
			distance[1] = 0;
			
			
			for(int i = 1; i < N; i++) {
				for(int j = 1; j < list.length; j++) {
					for(Edge edge : list[j]) {
					if(distance[edge.next] > distance[j] + edge.time) {
						distance[edge.next] = distance[j] + edge.time;
					}
				}
			}
			}
			
			boolean canBack = false;
			for(int j = 1; j < list.length; j++) {
				for(Edge edge : list[j]) {
					if(distance[edge.next] > distance[j] + edge.time) {
						canBack = true;
						break;
					}
				}
			}
			
			if(canBack) sb.append("YES\n");
			else sb.append("NO\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}