package boj.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_bitmasking_G4_18119 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] words = new int[N];
		int alpha = 0b11111111111111111111111111;
		
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			for(int j = 0; j < word.length(); j++) {
				words[i] |= 1 << word.charAt(j) - 'a';
			}
		}
		
		for(int i = 0; i < M; i++) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			switch(Integer.parseInt(st.nextToken())) {
			case 1:
				alpha &= ~(1 << st.nextToken().charAt(0) - 'a');
				for(int j = 0; j < words.length; j++) {
					if((words[j] & ~(alpha)) == 0) {
						cnt++;
					}
				}
				sb.append(cnt + "\n");
				break;
			default:
				alpha |= 1 << st.nextToken().charAt(0) - 'a';
				for(int j = 0; j < words.length; j++) {
					if((words[j] & ~(alpha)) == 0) {
						cnt++;
					}
				}
				sb.append(cnt + "\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}