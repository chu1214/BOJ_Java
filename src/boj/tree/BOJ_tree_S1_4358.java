package boj.tree;

import java.io.*;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BOJ_tree_S1_4358 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TreeMap<String, Integer> tm = new TreeMap<>();
		String name;
		int cnt = 0;
		
		while((name = br.readLine()) != null) {
			tm.put(name, tm.getOrDefault(name, 0) + 1);
			cnt++;
		}
		
		for(Entry<String, Integer> entry : tm.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			sb.append(key + " " + String.format("%.4f\n", ((double)value/cnt) * 100));
		}
		if(sb.length() != 0) sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}