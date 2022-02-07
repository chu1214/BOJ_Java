package boj.recursive;

import java.io.*;
import java.util.HashSet;

public class BOJ_recursive_S5_5568 {
	
	static int N, K;
	static String[] cards;
	static HashSet<String> numbers = new HashSet<>();
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		cards = new String[N];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			cards[i] = br.readLine();
		}
		
		permutation(0, "");
		
		System.out.println(numbers.size());
	}
	
	public static void permutation(int cnt, String str) {
		if(cnt == K) {
			numbers.add(str);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i] == true) continue;
			isSelected[i] = true;
			permutation(cnt + 1, str + cards[i]);
			isSelected[i] = false;
		}
	}
}