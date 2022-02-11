package swea.D4;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_D4_1861_정사각형방 {

	static int T, N;
	static int[][] rooms;
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int roomNum = Integer.MAX_VALUE;
	static int moveNum = 0;
	
	public static void dfs(int r, int c, int cnt, int start) {
		
		boolean isMoved = false;
		for(int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr, nc) && rooms[nr][nc] == rooms[r][c] + 1) {
				isMoved = true;
				dfs(nr, nc, cnt + 1, start);
			}
		}
		if(!isMoved) {
			if(cnt > moveNum) {
				roomNum = start;
				moveNum = cnt;
			} else if(cnt == moveNum && roomNum > start) {
				roomNum = start;
			}
		}
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
			rooms = new int[N][N];
			moveNum = 0;
			roomNum = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					dfs(i, j , 1, rooms[i][j]);
				}
			}
			sb.append("#" + t + " " + roomNum + " " + moveNum + "\n");	
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}