package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_6808_규영이와인영이의카드게임 {

	static int[] G;
	static boolean[] isSelected;
	static int Win = 0;
	static int Lose = 0;
	
	public static void permutation(int cnt, int gScore, int iScore, boolean[] isSelected) {
		if(cnt == 9) {
			if(iScore > gScore) Lose++;
			else if(iScore < gScore) Win++;
			return;
		}
		
		for(int i = 1; i <= 18; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				if(i > G[cnt]) iScore += i + G[cnt];
				else if(i < G[cnt]) gScore += i + G[cnt];
				permutation(cnt + 1, gScore, iScore, isSelected);
				if(i > G[cnt]) iScore -= i + G[cnt];
				else if(i < G[cnt]) gScore -= i + G[cnt];
				isSelected[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			Win = 0;
			Lose = 0;
			G = new int[9];
			isSelected = new boolean[19];
			
			for(int i = 0; i < 9; i++) {
				G[i] = Integer.parseInt(st.nextToken());
				isSelected[G[i]] = true;
			}
			permutation(0, 0, 0, isSelected);
			
			sb.append("#" + t + " " + Win + " " + Lose + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());	

	}
}