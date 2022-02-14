package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_bruteforce_S1_2961 {

	static int N;
	static int ans = Integer.MAX_VALUE;
	static Material[] list;
	static boolean[] isSelected;
	
	
	public static class Material {
		int sour, bitter;

		public Material(int sour, int bitter) {
			super();
			this.sour = sour;
			this.bitter = bitter;
		}
	}
	
	public static void makeFood(int cnt, boolean[] isSelected, int sour, int bitter) {
		if(cnt == N) {
			if(sour != 0 && bitter != 0 && ans > Math.abs(sour - bitter))
				ans = Math.abs(sour - bitter);
			return;
		}
		
		isSelected[cnt] = true;
		makeFood(cnt + 1, isSelected, sour * list[cnt].sour, bitter + list[cnt].bitter);
		isSelected[cnt] = false;
		makeFood(cnt + 1, isSelected, sour, bitter);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		list = new Material[N];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new Material(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		makeFood(0, isSelected, 1, 0);
		
		System.out.println(ans);
	}
}