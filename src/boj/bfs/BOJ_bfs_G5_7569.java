package boj.bfs;

import java.io.*;
import java.util.*;

public class BOJ_bfs_G5_7569 {

	static int M, N, H;
	static int[][][] Box;
	static int[] dx = {0, 0, 1, -1, 0, 0};
	static int[] dy = {0, 0, 0, 0, 1, -1};
	static int[] dz = {1, -1, 0, 0, 0, 0};
	static Queue<int[]> q = new ArrayDeque<int[]>();
	
	public static int bfs() {
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int[] tomato = q.poll();
				int x = tomato[2];
				int y = tomato[1];
				int z = tomato[0];
				
				for(int d = 0; d < 6; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					int nz = z + dz[d];
					
					if(isIn(nx, ny, nz) && Box[nz][ny][nx] == 0) {
						Box[nz][ny][nx] = 1;
						q.offer(new int[] {nz, ny, nx});
					}
				}
			}
			cnt++;
		}	
		if(!check()) return -1;
		
		return cnt - 1;
	}
	
	public static boolean check() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(Box[i][j][k] == 0) return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isIn(int nx, int ny, int nz) {
		return nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		Box = new int[H][N][M];
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++) {
					Box[i][j][k] = Integer.parseInt(st.nextToken());
					if(Box[i][j][k] == 1) q.offer(new int[] {i, j, k});
				}
			}
		}	
		System.out.println(bfs());
	}
}