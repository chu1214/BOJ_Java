package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_recursive_S3_2630 {

	static int N, White = 0, Blue = 0;
	static int[][] cp;
	
	public static void cut(int size, int r, int c) {
		boolean isWhite = false;
		boolean isBlue = false;
		boolean needCut = false;
		
		if(cp[r][c] == 1) isBlue = true;
		else isWhite = true;
		
		for(int i = r; i < r + size; i++) {
			if(needCut) break;
			for(int j = c; j < c + size; j++) {
				if((isWhite && cp[i][j] == 1) || (isBlue && cp[i][j] == 0)) {
					needCut = true;
					break;
				}
			}
		}
		
		if(needCut) {
			cut(size/2, r, c);
			cut(size/2, r, c + size/2);
			cut(size/2, r + size/2, c);
			cut(size/2, r + size/2, c + size/2);
			
		} else {
			if(isBlue) Blue++;
			if(isWhite) White++;
			return;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		cp = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				cp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(N, 0, 0);
		System.out.println(White + "\n" + Blue);
	}
}
