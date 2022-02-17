package boj.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_str_S4_1120 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String A = st.nextToken();
		String B = st.nextToken();
		
		int min = Integer.MAX_VALUE;
		int t = B.length() - A.length();
		
		for(int i = 0; i <= t; i++) {
			int cnt = 0;
			for(int j = 0; j < A.length(); j++) {
				if(A.charAt(j) != B.substring(i, A.length() + i).charAt(j)) {
					cnt++;
				}
			}
			if(cnt < min) min = cnt;
		}
		
		System.out.println(min);
	}
}