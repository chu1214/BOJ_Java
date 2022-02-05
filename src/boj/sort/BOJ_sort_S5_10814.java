package boj.sort;

import java.io.*;
import java.util.*;

public class BOJ_sort_S5_10814 {

	public static class Member implements Comparable<Member> {
		int age;
		String name;
		public Member(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(Member o) {
			return Integer.compare(this.age, o.age);
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Member[] m = new Member[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			m[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		Arrays.sort(m);
		
		for(Member member : m) {
			sb.append(member.age + " " + member.name + "\n");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}