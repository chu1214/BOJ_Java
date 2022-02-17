package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dfs_G4_1987 {

	static int R, C;
	static char[][] map;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int ans = 1;
	
	public static void move(int visited, int r, int c, int cnt) {
		boolean isMoved = false;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr, nc) && (visited & 1 << (map[nr][nc] - 'A')) == 0) {
				isMoved = true;
				move(visited | 1 << (map[nr][nc] - 'A'), nr, nc, cnt + 1);
			}
		}
		
		if(!isMoved && cnt > ans) {
			ans = cnt;
			return;
		}
	}
	
	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		move(0 | 1 << map[0][0] - 'A', 0, 0, 1);
		
		System.out.println(ans);
	}
}