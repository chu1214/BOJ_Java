package swea.D3;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_D3_5215_햄버거다이어트 {

	static int N, L;
	static Material[] Materials;
	static int Best;
	
	static class Material {
		int score, calories;

		public Material(int score, int calories) {
			super();
			this.score = score;
			this.calories = calories;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			Materials = new Material[N];
			Best = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Materials[i] = new Material(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			makeHamburger(0, 0, 0);
			sb.append("#" + t + " " + Best + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
	
	public static void makeHamburger(int cnt, int score, int calories) {
		if(cnt == N) {
			if(calories <= L && score > Best) Best = score;
			return;
		}
		
		makeHamburger(cnt + 1, score + Materials[cnt].score, calories + Materials[cnt].calories);
		makeHamburger(cnt + 1, score, calories);	
	}
}