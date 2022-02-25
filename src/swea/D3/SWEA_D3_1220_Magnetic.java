package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1220_Magnetic {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] table = new int[N][N];
			int ans = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int c = 0; c < N; c++) {
				boolean agg = false;
				for(int r = 0; r < N; r++) {
					if(!agg && table[r][c] == 1) {
						agg = true;
					}
					else if(agg && table[r][c] == 2) {
						agg = false;
						ans++;
					}
				}
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}