package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_graph_S2_1260 {

	static int N, M, V;
	static boolean[][] graph;
	static boolean[] isVisited;
	static Queue<Integer> q = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int num) {
		isVisited[num] = true;
		sb.append(num + " ");
		
		for(int i = 1; i <= N; i++) {
			if(graph[num][i] == true && !isVisited[i]) {
				dfs(i);
			}
		}
		return;
	}
	
	public static void bfs(int start) {
		q.offer(V);
		isVisited[start] = true;
		
		while(!q.isEmpty()) {
			int num = q.poll();
			sb.append(num + " ");
			
			for(int i = 1; i <= N; i++) {
				if(graph[num][i] == true && !isVisited[i]) {
					isVisited[i] = true;
					q.offer(i);
				}
			}	
		}
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new boolean[N+1][N+1];
		isVisited = new boolean[N+1];
				
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = true;
			graph[b][a] = true;
		}
		
		dfs(V);
		sb.setLength(sb.length() - 1);
		sb.append("\n");
		isVisited = new boolean[N+1];
		bfs(V);
		sb.setLength(sb.length() - 1);
		sb.append("\n");
		
		System.out.println(sb.toString());
			
	}
}