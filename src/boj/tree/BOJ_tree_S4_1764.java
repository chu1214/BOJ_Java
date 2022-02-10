package boj.tree;

import java.io.*;
import java.util.*;


public class BOJ_tree_S4_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		HashSet<String> hs = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			String name = br.readLine();
			hs.add(name);
		}
		
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			if(hs.contains(name)) {
				list.add(name);
			}
		}
		Collections.sort(list);
		sb.append(list.size() + "\n");
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}