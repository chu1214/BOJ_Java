package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D4_1238_Contact {

	static int len, start, ans;
	static Node[] graph;

	public static class Node {
		int data;
		Node link;

		public Node(int data, Node link) {
			super();
			this.data = data;
			this.link = link;
		}
	}

	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[101];
		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			int max = 0;
			for (int i = 0; i < size; i++) {
				int current = q.poll();
				if(current > max) max = current;
				
				for (Node node = graph[current]; node != null; node = node.link) {
					if (!visited[node.data]) {
						q.offer(node.data);
						visited[node.data] = true;
					}
				}
			}
			if(q.isEmpty()) {
				ans = max;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());

			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			graph = new Node[len];

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph[from] = new Node(to, graph[from]);
			}

			bfs(start);

			sb.append("#" + t + " " + ans + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}