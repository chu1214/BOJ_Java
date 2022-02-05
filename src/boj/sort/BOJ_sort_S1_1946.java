package boj.sort;

import java.io.*;
import java.util.*;

public class BOJ_sort_S1_1946 {

	public static class Candidate {
		int document, interview;

		public Candidate(int document, int interview) {
			super();
			this.document = document;
			this.interview = interview;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			Candidate[] priorityDocu = new Candidate[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Candidate cand = new Candidate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				priorityDocu[i] = cand;
			}
			
			Arrays.sort(priorityDocu, (o1, o2) -> {
				return Integer.compare(o1.document, o2.document);
			});
			
			int curInter = Integer.MAX_VALUE;
			int cnt = 0;
			
			for(int i = 0; i < priorityDocu.length; i++) {
				if(priorityDocu[i].interview < curInter) {
					curInter = priorityDocu[i].interview;
					cnt++;
				}
			}
			
			sb.append(cnt + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}