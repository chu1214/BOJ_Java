package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_stack_S2_2304 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		List<int[]> input = new ArrayList<>();
		Stack<int[]> s = new Stack<>();	
		
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] poll = new int[2];
			poll[0] = Integer.parseInt(st.nextToken());
			poll[1] = Integer.parseInt(st.nextToken());
			input.add(poll);
		}
		
		Collections.sort((List<int[]>) input, (o1, o2) -> {
			return Integer.compare(o1[0], o2[0]);
		});
		
		for(int i = 0; i < input.size(); i++) {
			int[] next = input.get(i);
			if(s.isEmpty()) {
				s.add(next);
				continue;
			} 
			int[] cur = s.peek();
			int[] prev = null;
			if(input.get(i)[1] > cur[1]) {
				while(!s.isEmpty() && input.get(i)[1] > s.peek()[1]) {
					prev = s.pop();
				}
				if(s.isEmpty())
					ans += (next[0] - prev[0]) * prev[1];
			}
			s.add(next);
		}
		
		while(!s.isEmpty()) {
			int[] next = s.pop();
			if(s.isEmpty()) {
				ans += next[1];
				break;
			}
			int[] cur = s.peek();
			ans += (next[0] - cur[0]) * next[1];
		}
		
		System.out.println(ans);
	}
}
