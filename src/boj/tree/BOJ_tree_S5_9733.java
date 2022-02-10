package boj.tree;

import java.io.*;
import java.util.*;

public class BOJ_tree_S5_9733 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		TreeMap<String, Integer> ts = new TreeMap<>();
		
		int cnt = 0;
		String str;
		while(((str = br.readLine()) != null)) {
			st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				String key = st.nextToken();
				ts.put(key, ts.getOrDefault(key, 0) + 1);
				cnt++;
			}
		}
		System.out.printf("Re %d %.2f\n", ts.getOrDefault("Re", 0), (double)ts.getOrDefault("Re", 0)/cnt);
		System.out.printf("Pt %d %.2f\n", ts.getOrDefault("Pt", 0), (double)ts.getOrDefault("Pt", 0)/cnt);
		System.out.printf("Cc %d %.2f\n", ts.getOrDefault("Cc", 0), (double)ts.getOrDefault("Cc", 0)/cnt);
		System.out.printf("Ea %d %.2f\n", ts.getOrDefault("Ea", 0), (double)ts.getOrDefault("Ea", 0)/cnt);
		System.out.printf("Tb %d %.2f\n", ts.getOrDefault("Tb", 0), (double)ts.getOrDefault("Tb", 0)/cnt);
		System.out.printf("Cm %d %.2f\n", ts.getOrDefault("Cm", 0), (double)ts.getOrDefault("Cm", 0)/cnt);
		System.out.printf("Ex %d %.2f\n", ts.getOrDefault("Ex", 0), (double)ts.getOrDefault("Ex", 0)/cnt);
		System.out.printf("Total %d %.2f\n", cnt, (double)ts.size()/ts.size());
	}
}