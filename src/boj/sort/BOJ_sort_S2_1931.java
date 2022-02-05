package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_sort_S2_1931 {
	
	static class Meeting implements Comparable<Meeting>{
		int s, e;
		
		public Meeting(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Meeting o) {
			if(this.e == o.e) {
				return -Integer.compare(this.s, o.s);
			}
			return -Integer.compare(this.e, o.e);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean isNot = false;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Meeting> m = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			Meeting meet = new Meeting(s, e);
			m.add(meet);
		}
		
		Collections.sort(m);
		
		int ce = 0;
		int cnt = 0;
		
		while(!m.isEmpty()) {	
			if(m.get(m.size() - 1).s < ce) {
				m.remove(m.size() - 1);
			} else {
				cnt++;
				ce = m.get(m.size() - 1).e;
				m.remove(m.size() - 1);
			}
		}
		System.out.println(cnt);
	}
}