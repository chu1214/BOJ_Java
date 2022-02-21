package boj.recursive;

import java.io.*;
import java.util.*;

public class BOJ_recursive_G5_1759 {

	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static char[] pos, choosed;
	
	public static void make(int cnt, int start, int vowel, int consonant) {
		if(vowel == L - 1 || consonant == L) return;
		
		if(cnt == L) {
			for(int i = 0; i < choosed.length; i++) {
				sb.append(choosed[i]);
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < pos.length; i++) {
			choosed[cnt] = pos[i];
			if(pos[i] == 'a' || pos[i] == 'e' || pos[i] == 'i'  || pos[i] == 'o'  || pos[i] == 'u') {
				make(cnt + 1, i + 1, vowel + 1, consonant);
			}
			else {
				make(cnt + 1, i + 1, vowel, consonant + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		pos = new char[C];
		choosed = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {			
			pos[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(pos);
		
		make(0, 0, 0, 0);
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}