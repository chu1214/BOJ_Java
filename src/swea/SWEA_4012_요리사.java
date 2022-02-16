package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {

	static int T, N;
	static int[][] synergy;
	static boolean[] material;
	static int min = Integer.MAX_VALUE;
	
	public static void cook(int cnt, int start) {
		if(cnt == N/2) {
			int tasteA = 0;
			int tasteB = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					if(material[i] && material[j]) {
						tasteA += synergy[i][j] + synergy[j][i];
					}
					if(!material[i] && !material[j]) {
						tasteB += synergy[i][j] + synergy[j][i];
					}
				}
			}
			int result = Math.abs(tasteB - tasteA);
			if(min > result) min = result;
		}
		
		for(int i = start; i < N; i++) {
			material[i] = true;
			cook(cnt + 1, i + 1);
			material[i] = false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			material = new boolean[N];
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cook(0, 0);
			
			sb.append("#" + t + " " + min + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}