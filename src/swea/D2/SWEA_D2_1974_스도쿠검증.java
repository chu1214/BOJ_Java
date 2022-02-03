package swea.D2;

import java.util.Scanner;

public class SWEA_D2_1974_스도쿠검증 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		int[][] sudoku = new int[9][9];
		
		for(int t = 1; t <= TC; t++) {
			boolean isNotSudoku = false;
			
			for(int r = 0; r < 9; r++) {
				for(int c = 0; c < 9; c++) {
					sudoku[r][c] = sc.nextInt();
				}
			}
			
	outer : for(int r = 0; r < 9; r++) {
				for(int c = 0; c < 9; c++) {
					for(int nr = 0; nr < 9; nr++) {
						if (sudoku[r][c] == sudoku[nr][c] && nr != r) {
							isNotSudoku = true;
							break outer;
						}
					}
					for (int nc = 0; nc < 9; nc++) {
						if (sudoku[r][c] == sudoku[r][nc] && nc != c) {
							isNotSudoku = true;
							break outer;
						}
					}
					for (int nr = (r / 3) * 3; nr < r / 3 + 3; nr++) {
						for(int nc = (c / 3) * 3; nc < c / 3 + 3; nc++) {
							if(sudoku[r][c] == sudoku[nr][nc] && (nr != r && nc != c)) {
								isNotSudoku = true;
								break outer;
							}
						}
					}
				}
			}
			if(!isNotSudoku)
				System.out.println("#" + t + " " + 1);
			else
				System.out.println("#" + t + " " + 0);
		}
	}
}