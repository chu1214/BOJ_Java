package boj.recursive;

import java.io.*;
public class BOJ_recursive_G5_9663 {
	
	static int N;
	static int[][] Board;
	static boolean[] usedColumn;
	static boolean[][] usedCross;
	static int nQueen = 0;

	public static void N_Queen(int r) {
		if (r == N) {
			nQueen++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if(!usedColumn[c] && !usedCross[0][r-c+N-1] && !usedCross[1][r+c]) {
				usedColumn[c] = true;
				usedCross[0][r-c+N-1] = true;
				usedCross[1][r+c] = true;	
				N_Queen(r + 1);
				usedColumn[c] = false;
				usedCross[0][r-c+N-1] = false;
				usedCross[1][r+c] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		Board = new int[N][N];
		usedColumn = new boolean[N];
		usedCross = new boolean[2][2*N];

		N_Queen(0);

		System.out.println(nQueen);
	}
}