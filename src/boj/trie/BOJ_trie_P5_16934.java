package boj.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BOJ_trie_P5_16934 {

	static int N;
	static ArrayList<String> nicknames = new ArrayList<>();

	static class Node {
		Map<Character, Node> child = new HashMap<>();
		int history = 0;
	}

	static class Trie {
		Node root = new Node();

		void insert(String str, String nickname) {
			Node node = this.root;
			for (int i = 0; i < str.length(); i++) {
				node = node.child.computeIfAbsent(str.charAt(i), key -> new Node());
				if (node.child.size() == 0 && nickname.equals("") && node.history == 0) {
					nickname = str.substring(0, i + 1);
				}
			}
			node.history++;
			if (nickname.equals("")) {
				nickname = str;
			}
			if (nickname.equals(str)) {
				if (node.history >= 2) {
					String num = "" + node.history;
					nickname = nickname.concat(num);
				}
			}
			nicknames.add(nickname);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();

		for (int i = 0; i < N; i++) {
			String user = br.readLine();
			trie.insert(user, "");
		}

		for (String nickname : nicknames) {
			sb.append(nickname + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
