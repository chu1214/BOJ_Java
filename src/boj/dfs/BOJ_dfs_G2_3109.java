package boj.dfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dfs_G2_3109 {

	static int R, C;
	static char[][] map;
	static int[] dx = {-1 ,0, 1};
	static int ans = 0;
	
	public static int find(int startR, int startC) {
		if(startC == C - 1) {
			return 1;
		}
		
		for(int d = 0; d < 3; d++) {
			int nr = startR + dx[d];
			int nc = startC + 1;
			if(isIn(nr, nc) && map[nr][nc] != 'x') {
				map[nr][nc] = 'x';
				if(find(nr, nc) == 1) return 1;
			}
		}
		return 0;
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
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < R; i++) {
			ans += find(i, 0);
		}
		br.close();
		System.out.println(ans);
	}
}