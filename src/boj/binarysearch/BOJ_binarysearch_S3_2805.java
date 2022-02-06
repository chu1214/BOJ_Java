package boj.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ_binarysearch_S3_2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];
		int left = 0;
		int right = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, trees[i]);
		}
		
		int ans = 0;
		
		while(left <= right) {
			long temp = 0;
			int mid = (left + right) / 2;
			for(int i = 0; i < N; i++) {
				if(trees[i] >= mid)
					temp += trees[i] - mid;
			}
			if(temp >= M) {
				ans = mid > ans ? mid : ans;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		System.out.println(ans);
	}
}