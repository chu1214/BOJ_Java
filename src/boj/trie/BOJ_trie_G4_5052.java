package boj.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_trie_G4_5052 {

	static int T, N;
	static boolean isOK;

	static class Node {
		Map<Character, Node> child = new HashMap<Character, Node>();
		boolean isEnd;
	}

	static class Trie {
		Node root = new Node();

		void insert(String str) {
			Node node = this.root;
			for (int i = 0; i < str.length(); i++) {
				node = node.child.computeIfAbsent(str.charAt(i), key -> new Node());
			}
			node.isEnd = true;
		}

		boolean search(String str) {
			Node node = this.root;
			for (int i = 0; i < str.length(); i++) {
				node = node.child.getOrDefault(str.charAt(i), null);
				if (node == null) {
					return false;
				}
			}

			if (node.child.size() != 0) {
				isOK = false;
			}

			return node.isEnd;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			Trie trie = new Trie();
			String[] words = new String[N];
			isOK = true;

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				words[i] = str;
				trie.insert(str);
			}

			for (int i = 0; i < N; i++) {
				trie.search(words[i]);
				if (!isOK)
					break;
			}

			if (isOK)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}