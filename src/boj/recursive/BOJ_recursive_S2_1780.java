package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_recursive_S2_1780 {
	
	static int N;
	static int[][] paper;
	static int a = 0, b = 0, d = 0;
	
	public static boolean check(int r, int c, int R, int C) {

		int temp = paper[r][c];
		 
		for(int i = r; i < R; i++) {
			for(int j = c; j < C; j++) {
				if(temp != paper[i][j]) return false;
			}
		}
		if(temp == -1) a++;
		else if(temp == 0) b++;
		else d++;
		return true;
	}
	
	public static void cut(int size, int r, int c, int R, int C) {
		if(!check(r, c, R, C)) {
			if(size == 0) {
				return;		
				}
			size /= 3;
			cut(size, r, c, r+size, c+size);
			cut(size, r, c+size, r+size, c+2*size);
			cut(size, r, c+2*size, r+size, c+3*size);
			cut(size, r+size, c, r+2*size, c+size);
			cut(size, r+size, c+size, r+2*size, c+2*size);
			cut(size, r+size, c+2*size, r+2*size, c+3*size);
			cut(size, r+2*size, c, r+3*size, c+size);
			cut(size, r+2*size, c+size, r+3*size, c+2*size);
			cut(size, r+2*size, c+2*size, r+3*size, c+3*size);
		}
		return;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cut(N, 0, 0, N, N);
		
		sb.append(a + "\n" + b + "\n" + d);
		System.out.println(sb.toString());
	}
}