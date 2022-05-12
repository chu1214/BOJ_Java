package boj.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BOJ_trie_G2_7432 {

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

	public static void explore(Node cur, String depth) {
		Object[] keys = cur.child.keySet().toArray();

		for (Object key : keys) {
			Node next = cur.child.get(key);
			String str = (String) key;
			sb.append(depth + str + "\n");
			explore(next, depth + " ");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();

		for (int i = 0; i < N; i++) {
			String[] strs = br.readLine().split("\\\\");
			trie.insert(strs);
		}

		explore(trie.root, "");

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}