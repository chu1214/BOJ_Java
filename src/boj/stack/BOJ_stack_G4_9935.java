package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_stack_G4_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String bomb = br.readLine();

		Stack<Character> s = new Stack<>();
		Stack<Integer> memory = new Stack<>();
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			s.push(str.charAt(i));
			if (str.charAt(i) == bomb.charAt(cnt)) {
				cnt++;
			} else {
				if (str.charAt(i) == bomb.charAt(0)) {
					if (cnt != 0) {
						memory.push(cnt);
						cnt = 1;
					}
				} else {
					cnt = 0;
					if(!memory.isEmpty()) {
						while(!memory.isEmpty()) {
							memory.pop();
						}
					}
				}
			}
			if (cnt == bomb.length()) {
				while (cnt-- > 0) {
					s.pop();
				}
				if (!memory.isEmpty()) {
					cnt = memory.pop();
				} else {
					cnt = 0;

				}
			}
		}

		if (s.isEmpty())
			System.out.println("FRULA");
		else {
			while (!s.isEmpty()) {
				sb.append(s.pop());
			}
			sb.reverse();
			System.out.println(sb.toString());
		}
	}
}