package boj.graph;

import java.io.*;
import java.util.*;

public class BOJ_graph_S2_1260_nodeVer {

	static int N, M, V;
	static Node[] graph;
	static StringBuilder sb = new StringBuilder();

	public static class Node {
		int data;
		Node link;

		public Node(int data, Node link) {
			super();
			this.data = data;
			this.link = link;
		}
	}

	public static void dfs(boolean[] visited, int current) {
		sb.append(current + " ");
		List<Integer> list = new ArrayList<>();
		for (Node node = graph[current]; node != null; node = node.link) {
			if (!visited[node.data]) {
				list.add(node.data);
			}
		}

		Collections.sort(list);

		for (int num : list) {
			if (!visited[num]) {
				visited[num] = true;
				dfs(visited, num);
			}
		}
	}

	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		List<Integer> list = new ArrayList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			sb.append(current + " ");
			for(Node node = graph[current]; node != null; node = node.link) {
				if (!visited[node.data]) {
					list.add(node.data);
					visited[node.data] = true;
				}
			}
			Collections.sort(list);
			for(int num : list) {
				q.offer(num);
			}
			list.clear();
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new Node[N + 1];

		boolean[] visited = new boolean[N + 1];
		visited[V] = true;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a] = new Node(b, graph[a]);
			graph[b] = new Node(a, graph[b]);
		}

		dfs(visited, V);
		sb.setLength(sb.length() - 1);
		sb.append("\n");
		bfs(V);
		sb.setLength(sb.length() - 1);

		System.out.println(sb.toString());
	}
}