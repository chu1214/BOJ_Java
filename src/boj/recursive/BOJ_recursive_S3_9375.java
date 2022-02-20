package boj.recursive;

import java.io.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BOJ_recursive_S3_9375 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			HashMap<String, Integer> hm = new HashMap<>();
			
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String category = st.nextToken();
				hm.put(category, hm.getOrDefault(category, 1) + 1);
			}
			
			int ans = 1;
			
			for(Entry e : hm.entrySet()) {
				ans *= (Integer)e.getValue();
			}
			
			sb.append(ans - 1 + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}