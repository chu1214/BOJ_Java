package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_B2_13300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] student = new int[2][6];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			student[gender][grade - 1]++;
		}
		
		int ans = 0;
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				if(student[i][j] - 1 >= 0) {
					ans += (student[i][j] - 1) / K + 1;
				}
			}
		}
		
		System.out.println(ans);
	}
}