package boj.recursive;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_recursive_S2_6603 {

	static int K;
	static int[] inputs, lotto;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		
		while(!((str = br.readLine()).equals("0"))) {
			st = new StringTokenizer(str);
			K = Integer.parseInt(st.nextToken());
			inputs = new int[K];
			lotto = new int[6];
			for(int i = 0; i < K; i++) {
				inputs[i] = Integer.parseInt(st.nextToken());
			}
			makeLotto(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void makeLotto(int cnt, int start) {
		if(cnt == 6) {
			for(int i = 0; i < 6; i++)
				sb.append(lotto[i] + " ");
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < K; i++) {
			lotto[cnt] = inputs[i];
			makeLotto(cnt + 1, i + 1);
		}
	}
}