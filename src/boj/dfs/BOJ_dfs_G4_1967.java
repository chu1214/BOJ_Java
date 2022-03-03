package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_dfs_G4_1967 {

	static class Node {
		int next, cost;

		public Node(int next, int cost) {
			super();
			this.next = next;
			this.cost = cost;
		}
		
	}
	
	static int N, ans = 0;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	
	public static void dfs(int cur, int sum) {
		boolean isEnd = true;
		visited[cur] = true;
		for(int i = 0; i < list[cur].size(); i++) {
			int next = list[cur].get(i).next;
			int cost = list[cur].get(i).cost;
			if(visited[next]) continue;
			isEnd = false;
			dfs(next, sum + cost);
		}
		if(isEnd) ans = Math.max(ans, sum);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			dfs(i, 0);
		}
		
		System.out.println(ans);
	}
}