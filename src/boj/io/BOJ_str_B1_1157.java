package boj.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_str_B1_1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.toUpperCase();
		int[] used = new int[26];
		
		for(int i = 0; i < str.length(); i++) {
			used[str.charAt(i) - 'A']++;
		}
		
		int max = 0;
		int maxIdx = -1;
		int cnt = 0;
		
		for(int i = 0; i < used.length; i++) {
			if(max < used[i]) {
				max = used[i];
				maxIdx = i;
			}
		}
		
		for(int i : used) {
			if(max == i) {
				cnt++;
			}
		}
		
		if(cnt > 1) {
			System.out.println("?");
		} else {
			System.out.println((char)(maxIdx + 'A'));
		}

	}

}