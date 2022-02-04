package boj.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_binarysearch_S3_1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] multitap = new int[N];
		int max = 0;
		
		for(int i = 0; i < K; i++) {
			multitap[i] = Integer.parseInt(br.readLine());
			if(multitap[i] > max) max = multitap[i]; 
		}
		
		long left = 1;
		long right = max;
		long ans = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			int temp = 0;
			for(int i = 0; i < K; i++) {
				temp += multitap[i] / mid;
			}
			if(temp >= N) {
				ans = mid > ans ? mid : ans;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}
}