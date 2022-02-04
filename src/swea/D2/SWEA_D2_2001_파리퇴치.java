package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D2_2001_파리퇴치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] area = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					area[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = -1;
			
			for(int i = 0; i <= N - M; i++) {
				for(int j = 0; j <= N - M; j++) {
					int sum = 0;
					for(int k = 0; k < M; k++) {
						for(int l = 0; l < M; l++) {
							sum += area[i + k][j + l];
						}
					}
					max = sum > max ? sum : max; 
				}
			}
			sb.append("#" + t + " " + max + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}