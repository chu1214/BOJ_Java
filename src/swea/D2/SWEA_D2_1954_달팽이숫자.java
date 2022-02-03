package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D2_1954_달팽이숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int num = 1;
			boolean cantMove = false;
			int N = Integer.parseInt(br.readLine());
			int[][] snail = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			int r = -1;
			int c = 0;
			
			while (!cantMove) {
				for (int i = 0; i < 4; i++) {
					int nr = r + deltas[i][0];
					int nc = c + deltas[i][1];

					if ((0 <= nr && nr < N && 0 <= nc && nc < N) && !visited[nr][nc]) {
						snail[nr][nc] = num++;
						visited[nr][nc] = true;
						r = nr;
						c = nc;
						break;
					}
					if(i == 3) cantMove = true;
				}
			}
			sb.append("#" + t + "\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(snail[i][j] + " ");
				}
				sb.setLength(sb.length() - 1);
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}