package boj.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_str_B1_1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		String str1;
		
		while(!(str1 = br.readLine()).equals("0")) {
			String str2 = "";
			sb = new StringBuilder();
			sb.append(str2);
			
			for(int i = str1.length() - 1; i >= 0; i--) {
				sb.append(str1.charAt(i));
			}
			
			str2 = sb.toString();
			
			if(str1.equals(str2)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}