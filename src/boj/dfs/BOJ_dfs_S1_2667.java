package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_dfs_S1_2667 {
	
	static int N, cnt = 0;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!isIn(nr, nc) || visited[nr][nc]) continue;
			if(map[nr][nc] == 1) {
				dfs(nr, nc);
				cnt++;
			}
		}
	}
	
	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					cnt = 1;
					dfs(i, j);
					if(cnt != 0) ans.add(cnt);
				}
			}
		}
		ans.sort(null);
		
		sb.append(ans.size() + "\n");
		
		for(int result : ans) {
			sb.append(result + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}