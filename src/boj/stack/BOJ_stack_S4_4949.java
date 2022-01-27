package boj.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_stack_S4_4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;

		while (true) {
			str = br.readLine();
			boolean isEnd = false;
			if (str.equals(".")) {
				bw.flush();
				bw.close();
				return;
			}
			Stack<Character> s = new Stack<>();
			str = str.replaceAll("[.a-zA-Z\\s]", "");
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '[')
					s.push(str.charAt(i));
				else {
					if (!(s.isEmpty())) {
						if ((s.peek() == '(' && str.charAt(i) == ')') || (s.peek() == '[' && str.charAt(i) == ']')) {
							s.pop();
						} else {
							bw.write("no\n");
							isEnd = true;
							break;
						}
					} else {
						bw.write("no\n");
						isEnd = true;
						break;

					}
				}
			}
			if(!isEnd && s.isEmpty()) {
				bw.write("yes\n");
			}else if(!isEnd && !(s.isEmpty())) {
					bw.write("no\n");
			}
		}
	}
}