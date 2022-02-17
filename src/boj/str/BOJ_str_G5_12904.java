package boj.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_str_G5_12904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		String str;
		
		sb.append(br.readLine());
		
		while(true) {
			if(sb.charAt(sb.length() - 1) == 'A') {
				sb.setLength(sb.length() - 1);
			}else if(sb.charAt(sb.length() - 1) == 'B') {
				sb.setLength(sb.length() - 1);
				sb.reverse();
			}
			str = sb.toString();
			if(str.equals(S) || str.isEmpty()) break;
		}
		
		if(str.length() > 0) System.out.println(1);
		else System.out.println(0);
	}
}