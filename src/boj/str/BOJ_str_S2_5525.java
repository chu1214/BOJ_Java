package boj.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_str_S2_5525 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int ans = 0;
		
		String str = br.readLine();
		
		for(int i = 0; i < M - 2; i++) {
			if(str.charAt(i) == 'O') continue;
			int O = 0;
			while(str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I') {
				O++;	
				i += 2;
				if(O == N) {
					O--;
					ans++;
				}
				if(i >= M - 2) break;
			}
		}
		System.out.println(ans);
	}
}