package boj.bruteforce;

import java.io.*;
import java.util.*;

public class BOJ_bruteforce_B2_2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine()); 
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int ans = 0;
		
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {
					int temp = list.get(i) + list.get(j) + list.get(k);
					if (temp == M) {
						System.out.println(M);
						return;
					} else if(temp <= M && Math.abs(temp - M) < Math.abs(ans - M)) {
						ans = temp;
					}
				}
			}
		}
		System.out.println(ans);
	}
}