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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		Deque<Integer> dq = new ArrayDeque<Integer>();
		
		int arr[] = new int[1000001];
		Arrays.fill(arr, Integer.MIN_VALUE);
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= M; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[a] = 0;
			dq.offerLast(a);
		}
		
		while(!dq.isEmpty()) {
			int a = dq.pollFirst();
			for(int i = 0; i < 20; i++) {
				int next = a^(1 << i);
				if(next > N || arr[next] != Integer.MIN_VALUE) continue;
				arr[next] = arr[next] + 1;
				dq.offerLast(next);
				ans = Math.max(ans, arr[next]);
			}
		}
		
		System.out.println(ans);
	}
}