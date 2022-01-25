package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_S5_1018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		String str;
		
		for(int n = 0; n < N; n++) {
			str = br.readLine();
			for(int m = 0; m < M; m++) {
				map[n][m] = str.charAt(m);
			}
		}
		int min = Integer.MAX_VALUE;
		for(int n = 0; n < N - 7; n++) {
			for(int m = 0; m < M - 7; m++) {
				int cnt1 = 0;
				int cnt2 = 0;
				int firstColor = (n + m) % 2;
				for(int i = n; i < n + 8; i++) {
					for(int j = m; j < m + 8; j++) {
						int stayColor = (i + j) % 2;
						if(firstColor == stayColor && map[n][m] != map[i][j]) {
							cnt1++;
						}else if(firstColor != stayColor && map[n][m] == map[i][j]) {
							cnt1++;
						}else if(firstColor == stayColor && map[n][m] == map[i][j]) {
							cnt2++;
						}else if(firstColor != stayColor && map[n][m] != map[i][j]) {
							cnt2++;
						}
					}
				}
				if(min > cnt1 || min > cnt2)
					min = cnt1 < cnt2 ? cnt1: cnt2;
			}
		}
		System.out.println(min);
	}
}