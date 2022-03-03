package boj.tree;

import java.io.*;
import java.util.*;
public class BOJ_tree_S2_11725 {
	
	static int N;
	static Queue<Integer> q = new ArrayDeque<>();
	static ArrayList<Integer>[] tree;
	static int[] parent;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void bfs(int root) {
		q.offer(root);
		visited[root] = true;
	
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i : tree[cur]) {
				if(!visited[i]) {
					parent[i] = cur;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		for(int i = 2; i <= N; i++) 
			sb.append(parent[i] + "\n");
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		parent = new int[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		bfs(1);
	}
}