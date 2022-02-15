package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_sort_S3_11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] atm = new int[N];
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			atm[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(atm);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				ans += atm[j];
			}
		}
		System.out.println(ans);
	}

}
