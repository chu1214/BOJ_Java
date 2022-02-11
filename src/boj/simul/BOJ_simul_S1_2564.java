package boj.simul;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_simul_S1_2564 {

	static int N, M, S;
	static int[] D;
	static int[][] shop;
	static int ans = 0;

	public static void find() {
		for (int i = 0; i < S; i++) {
			int first = 0, second = 0;
			switch (D[0]) {
			case 1:
				if(shop[i][0] == 1) {
					ans += Math.abs(shop[i][1] - D[1]);
				} else if(shop[i][0] == 2 ) {
					first = N + (M - shop[i][1]) + (M - D[1]);
					second = N + D[1] + shop[i][1];
					ans += first > second ? second : first;
				} else if(shop[i][0] == 3 ) {
					ans += D[1] + shop[i][1];
				} else {
					ans += (M - D[1]) + shop[i][1];
				}
				break;
			case 2:
				if(shop[i][0] == 1) {
					first = N + (M - shop[i][1]) + (M - D[1]);
					second = N + D[1] + shop[i][1];
					ans += first > second ? second : first;
				} else if(shop[i][0] == 2 ) {
					ans += Math.abs(shop[i][1] - D[1]);
				} else if(shop[i][0] == 3 ) {
					ans += D[1] + (N - shop[i][1]);
				} else {
					ans += (M - D[1]) + (N - shop[i][1]);
				}
				break;
			case 3:
				if(shop[i][0] == 1) {
					ans += D[1] + shop[i][1]; 
				} else if(shop[i][0] == 2 ) {
					ans += (N - D[1]) + shop[i][1];
				} else if(shop[i][0] == 3 ) {
					ans += Math.abs(shop[i][1] - D[1]);
				} else {
					first = M + shop[i][1] + (N - D[1]);
					second = M + D[1] + (N - shop[i][1]);
					ans += first > second ? second : first;
				}
				break;
			case 4:
				if(shop[i][0] == 1) {
					ans += D[1] + (M - shop[i][1]); 
				} else if(shop[i][0] == 2 ) {
					ans += (N - D[1]) + (M - shop[i][1]);
				} else if(shop[i][0] == 3 ) {
					first = M + shop[i][1] + (N - D[1]);
					second = M + D[1] + (N - shop[i][1]);
					ans += first > second ? second : first;
				} else {
					ans += Math.abs(shop[i][1] - D[1]);
				}
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(br.readLine());

		shop = new int[S][2];
		D = new int[2];

		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			shop[i][0] = Integer.parseInt(st.nextToken());
			shop[i][1] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		D[0] = Integer.parseInt(st.nextToken());
		D[1] = Integer.parseInt(st.nextToken());

		find();

		System.out.println(ans);
	}
}