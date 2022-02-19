package boj.graph;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_graph_G2_2263 {

	static int N, idx = 1;
	static int[] inOrder, postOrder, pos;
	static StringBuilder sb = new StringBuilder();
	
	public static void makePreOrder(int inStart, int inEnd, int postStart, int postEnd) {
		if(inStart > inEnd || postStart > postEnd)
			return;
		
		int root = postOrder[postEnd];
		sb.append(root + " ");
		
		makePreOrder(inStart, pos[root] - 1, postStart, postStart + (pos[root] - inStart) - 1);
		makePreOrder(pos[root] + 1, inEnd, postStart + pos[root] - inStart, postEnd - 1);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		inOrder = new int[N];
		postOrder = new int[N];
		pos = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			pos[inOrder[i]] = i;
		}
		
		makePreOrder(0, N - 1, 0, N - 1);
		System.out.println(sb.toString());
	}

}