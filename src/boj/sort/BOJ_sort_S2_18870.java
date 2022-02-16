package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_sort_S2_18870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> sorted = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(num);
			sorted.add(num);
		}
		
		Collections.sort(sorted);
		int cnt = 0;
		
		for(int i = 0; i < sorted.size(); i++) {
			int num = sorted.get(i);
			if(!hm.containsKey(num)) {
				hm.put(num, cnt++);
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(hm.get(list.get(i)) + " ");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}