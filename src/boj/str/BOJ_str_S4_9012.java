package boj.str;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_str_S4_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			Stack<String> s = new Stack<>();
			String str = br.readLine();
			boolean isVPS = true;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') {
					s.push(" ");
				} else if(str.charAt(i) == ')') {
					if(s.empty()) {
						isVPS = false;
						break;
					} else {
						s.pop();
					}
				}		
			}
			if(s.empty() && isVPS) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}