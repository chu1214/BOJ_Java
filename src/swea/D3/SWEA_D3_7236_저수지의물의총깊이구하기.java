package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_7236_저수지의물의총깊이구하기 {

	static int T, N, ANS;
	static char[][] area;
	static int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
	
	
	public static void check(int r, int c) {
		int depth = 0;
		for(int d = 0; d < 8; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr, nc) && area[nr][nc] == 'W') {
				depth++;
			}
		}
		if(depth == 0) depth = 1;
		if(ANS < depth) ANS = depth; 
		return;
	}
	
	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			area = new char[N][N];
			ANS = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					area[i][j] = st.nextToken().charAt(0);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					check(i, j);
				}
			}
			
			sb.append("#" + t + " " + ANS + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());	
	}
}