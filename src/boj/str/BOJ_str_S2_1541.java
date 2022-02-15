package boj.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_str_S2_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		boolean minus = false;
		int pos = 0;
		int neg = 0;
		int num = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '+') {
				if(minus) neg += num;
				else pos += num;
				num = 0;
			} else if(str.charAt(i) == '-') {
				if(!minus) pos += num;
				else neg += num;
				minus = true;
				num = 0;
			} else {
				num = num * 10 + (str.charAt(i) - '0');
			}	
		}
		if(minus) neg += num;
		else pos += num;
		System.out.println(pos - neg);
	}
}