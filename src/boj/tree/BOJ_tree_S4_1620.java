package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_tree_S4_1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		HashMap<String, Integer> hm = new HashMap<>();
		List<String> list = new ArrayList<>();
		list.add("");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			String name = br.readLine();
			hm.put(name, i);
			list.add(name);
		}
		
		for(int i = 0; i < M; i++) {
			String question = br.readLine();
			if(question.charAt(0) < 65) {
				sb.append(list.get(Integer.parseInt(question)) + "\n");
			} else {
				int num = hm.get(question);
				sb.append(num + "\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}