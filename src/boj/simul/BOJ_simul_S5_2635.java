package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_simul_S5_2635 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		int save = 0;
		
		
		for(int i = 1; i <= N; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(N);
			if(N > 1) {
				list.add(N - i);
			} else if(N == 1) {
				list.add(1);
			}
			int cnt = 2;
			while(true) {
				int made = list.get(cnt - 2) - list.get(cnt - 1);
				if(made < 0) break;
				list.add(made);
				cnt++;
			}
			if(cnt > ans) {
				if(N > 1) {
					save = N - i;
				} else if(N == 1) {
					save = 1;
				}
				ans = cnt;
			}
		}
		
		int[] answer = new int[ans];
		
		answer[0] = N;
		answer[1] = save;
		sb.append(ans + "\n" + answer[0] + " " + answer[1] + " ");
		
		for(int i = 2; i < ans; i++) {
			answer[i] = answer[i-2] - answer[i-1];
			sb.append(answer[i] + " ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}