package boj.simul;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_simul_S3_2491 {
	
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int ans = 1;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int up = 1;
		int down = 1;
		
		for(int i = 1; i < N; i++) {
			if(arr[i] > arr[i-1]) {
				up++;
				down = 1;
			} else if (arr[i] < arr[i-1]) {
				down++;
				up = 1;
			} else {
				up++;
				down++;
			}
			if(Math.max(up, down) >= ans) ans = Math.max(up, down);
		}	
			System.out.println(ans);
	}
}