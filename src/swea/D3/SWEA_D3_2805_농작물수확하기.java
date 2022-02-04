package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			int r = 0, c = 0;
			int ans = 0;
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}
			for(int i = 0; i <= N / 2; i++) {
				r = i;
				c = 0;
				for(int j = 0; j < N / 2 - i; j++) c++;
				for(int j = 0; j < 2 * i + 1; j++) {
					ans += farm[r][c];
					c++;
				}
			}
			for(int i = 1; i <= N / 2; i++) {
				r = N / 2 + i;
				c = 0;
				for(int j = 0; j < i; j++) c++;
				for(int j = 0; j < N - 2 * i; j++) {
					ans += farm[r][c];
					c++;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}