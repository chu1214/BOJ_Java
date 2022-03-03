package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_tree_G5_1068 {
	
	static int N, cnt;
	static int[] parent;
	static boolean[] visited;
	
	public static void delete(int del) {
		parent[del] = -2;
		for(int i = 0; i < N; i++) {
			if(parent[i] == del) {
				delete(i);
			}
		}
	}
	
	public static void dfs(int leaf) {
		boolean isEnd = true;
		visited[leaf] = true;
		if(parent[leaf] != -2) {
			for(int i = 0; i < N; i++) {
				if(parent[i] == leaf) {
					dfs(i);
					isEnd = false;
				}
			}
			if(isEnd) cnt++; 
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		cnt = 0;
		int root = 0;
		
		parent = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
			if(parent[i] == -1) root = i;
		}
		
		int del = Integer.parseInt(br.readLine());
		delete(del);
		
		dfs(root);
		
		System.out.println(cnt);
	}
}	