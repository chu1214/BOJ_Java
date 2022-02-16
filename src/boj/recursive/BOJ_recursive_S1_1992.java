package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_recursive_S1_1992 {
	
	static int N;
	static int[][] video;
	static StringBuilder sb = new StringBuilder();
	
	public static void compression(int size, int r, int c) {
		boolean isBlack;
		boolean needCompression = false;
		
		if(video[r][c] == 1) isBlack = true;
		else isBlack = false;
		
		for(int i = r; i < r + size; i++) {
			if(needCompression) break;
			for(int j = c; j < c + size; j++) {
				if((isBlack & video[i][j] == 0) || (!isBlack & video[i][j] == 1)) { 
					needCompression = true;
					break;
				}
			}
		}
		
		if(needCompression) {
			sb.append("(");
			compression(size / 2, r, c);
			compression(size / 2, r, c + size / 2);
			compression(size / 2, r + size / 2, c);
			compression(size / 2, r + size / 2, c + size / 2);
			sb.append(")");
		} else {
			if(isBlack) sb.append(1 + "");
			else sb.append(0 + "");
			return;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				video[i][j] = str.charAt(j) - '0';
			}
		}
		
		compression(N, 0, 0);
		
		System.out.println(sb.toString());
	}
}