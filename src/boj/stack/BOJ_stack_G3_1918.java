package boj.stack;

import java.io.*;
import java.util.Stack;

public class BOJ_stack_G3_1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		Stack<Character> s = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if (a >= 65 && a < 97) {
				sb.append(a);
				continue;
			}
			if (s.isEmpty()) {
				s.push(a);
				continue;
			}
			if (a == '*' || a == '/') {
				if (s.peek() == '+' || s.peek() == '-' || s.peek() == '(') {
					s.push(a);
				} else if (s.peek() == '*' || s.peek() == '/') {
					sb.append(s.pop());
					s.push(a);
				}
			} else if (a == '+' || a == '-') {
				if (s.peek() == '(')
					s.push(a);
				else {
					while (!s.isEmpty() && !(s.peek() == '('))
						sb.append(s.pop());
					s.push(a);
				}
			} else if(a == '(') {
				s.push(a);
			} else if(a == ')') {
				while(!s.isEmpty() && !(s.peek() == '(')) {
					sb.append(s.pop());
				}
				s.pop();
			}
		}
		while(!s.isEmpty()) sb.append(s.pop());
		System.out.println(sb.toString());
	}
}