package boj.lca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_lca_G1_2233 {

	static class Node {
		int in, out, parent;

		public Node() {
			super();
		}

		public Node(int in, int out, int parent) {
			super();
			this.in = in;
			this.out = out;
			this.parent = parent;
		}
	}

	static int N;
	static Stack<Integer> s = new Stack<>();
	static Node[] nodes;
	static String info;
	static int[] rot;

	public static int lca(int a, int b) {
		if (a == b)
			return a;

		boolean[] check = new boolean[N];

		// a 부터 조상님 체크
		while (true) {
			// 방문 체크
			check[a] = true;
			// 루트노드에 도달했으면 나가기
			if (nodes[a].parent == -1)
				break;
			// 루트노드가 아니라면 부모로 올라가기
			a = nodes[a].parent;
		}

		// b 조상님 체크
		while (true) {
			// 최소 공통 조상님을 찾았다면 리턴
			if (check[b])
				return b;
			// 아니라면 부모로 올라가기
			b = nodes[b].parent;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		info = br.readLine();
		nodes = new Node[N];
		rot = new int[2];

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int in = -1;
		int out = -1;
		for (int i = 0; i < info.length(); i++) {
			if (info.charAt(i) == '0') {
				in++;
				nodes[in] = new Node();
				nodes[in].in = i;
				if (!s.isEmpty()) {
					nodes[in].parent = s.peek();
				}
				s.add(in);
				if (x == i + 1)
					rot[0] = in;
				if (y == i + 1)
					rot[1] = in;
			} else {
				out = s.peek();
				nodes[out].out = i;
				if (x == i + 1)
					rot[0] = out;
				if (y == i + 1)
					rot[1] = out;
				out = nodes[out].parent;
				s.pop();
			}
		}

		// 루트 노드임을 명시
		nodes[0].parent = -1;
		int lca = lca(rot[0], rot[1]);

		System.out.println((nodes[lca].in + 1) + " " + (nodes[lca].out + 1));
	}
}