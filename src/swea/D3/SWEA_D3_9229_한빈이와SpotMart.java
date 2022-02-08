package swea.D3;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_D3_9229_한빈이와SpotMart {

	static int[] snack, hb;
	static int N, M;
	static int Max = -1;
	
	public static void combination(int cnt, int start) {
		if(cnt == 2) {
			int temp = 0;;
			for(int i = 0; i < 2; i++) {
				temp += hb[i];
			}
			if(temp <= M && Max < temp) {
				Max = temp;
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			hb[cnt] = snack[i];
			combination(cnt + 1, i + 1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= TC; t++) {
			Max = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			hb = new int[2];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			
			sb.append("#" + t + " " + Max + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}