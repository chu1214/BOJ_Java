package boj.str;

import java.io.*;
import java.util.Stack;

public class BOJ_str_S3_17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> s = new Stack<>();
		StringBuilder sb;
		boolean isTag = false;

		String str = br.readLine();
		sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if (isTag == false) {
				if (str.charAt(i) == '<') {
					isTag = true;
					int temp = s.size();
					for (int j = 0; j < temp; j++) {
						sb.append(s.pop());
					}
					sb.append(str.charAt(i));
				} else if (str.charAt(i) == ' ' || i == str.length() - 1) {
					int temp = s.size();
					if(i == str.length() - 1) sb.append(str.charAt(i));
					for (int j = 0; j < temp; j++) {
						sb.append(s.pop());
					}
					if(str.charAt(i) == ' ') sb.append(' ');
				} else {
					s.push(str.charAt(i));
				}
			}
			else {
				if (str.charAt(i) == '>') isTag = false;
				sb.append(str.charAt(i));	
			}
		}
		bw.write(sb.toString() + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
}