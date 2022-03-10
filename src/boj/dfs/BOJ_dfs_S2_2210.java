package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_dfs_S2_2210 {

	static HashSet<String> s = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	static int[][] map = new int[5][5];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void make(int cnt, int r, int c) {
		if(cnt == 6) {
			s.add(sb.toString());
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isIn(nr, nc)) {
				sb.append(map[nr][nc]);
				make(cnt + 1, nr, nc);
				sb.setLength(sb.length() - 1);
			}
		}
	}
	
	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < 5 && nc >= 0 && nc < 5;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				make(0, i, j);
			}
		}
		System.out.println(s.size());
	}
}
