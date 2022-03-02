package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_bfs_P5_20304 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int ans = 0;
		
		Deque<Integer> dq = new ArrayDeque<Integer>();
		
		int arr[] = new int[1000001];
		Arrays.fill(arr, Integer.MIN_VALUE);
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= M; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[x] = 0;
			dq.offerLast(x);
		}
		
		while(!dq.isEmpty()) {
			int x = dq.pollFirst();
			for(int i = 0; i < 20; i++) {
				int nx = x^(1 << i);
				if(nx > N || arr[nx] != Integer.MIN_VALUE) continue;
				arr[nx] = arr[x] + 1;
				dq.offerLast(nx);
				ans = Math.max(ans, arr[nx]);
			}
		}
		
		System.out.println(ans);
	}
}