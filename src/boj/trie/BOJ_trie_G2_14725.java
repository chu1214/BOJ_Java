package boj.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_trie_G2_14725 {

	static int N;
	static StringBuilder sb = new StringBuilder();

	static class Node {
		Map<String, Node> child = new TreeMap<String, Node>();
	}

	static class Trie {
		Node root = new Node();

		void insert(String[] strs) {
			Node node = this.root;
			for (int i = 0; i < strs.length; i++) {
				node = node.child.computeIfAbsent(strs[i], key -> new Node());
			}
		}
	}

	public static void find(Node cur, String bar) {
		Node node = cur;
		Object[] strs = node.child.keySet().toArray();

		for (Object s : strs) {
			String str = (String) s;
			Node next = node.child.get(str);
			sb.append(bar + str + "\n");
			find(next, bar + "--");
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			String[] strs = new String[K];

			for (int j = 0; j < K; j++) {
				strs[j] = st.nextToken();
			}

			trie.insert(strs);
		}

		find(trie.root, "");

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}