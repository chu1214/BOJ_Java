package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dfs_G4_15684 {
	
	static int N, M, H, ans = -1;
	static int[][] ladder;
	static boolean isFound = false;
	
	public static void dfs(int num, int limit) {
		if(isFound) return;
		if(num == limit) {
			if(check()) {
				ans = limit;
				isFound = true;
			}
			return;
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j <= H; j++) {
				if(ladder[i][j] == 0 && ladder[i+1][j] == 0) {
					ladder[i][j] = 1;
					ladder[i+1][j] = -1;
					dfs(num + 1, limit);
					ladder[i][j] = 0;
					ladder[i+1][j] = 0;
				}
			}
		}
	}
	
	public static boolean check() {
		for(int i = 1; i <= N; i++) {
			int l = i;
			int d = 1;
			
			while(d <= H) {
				if(ladder[l][d] == 1) l++;
				else if(ladder[l][d] == -1) l--;
				d++;
			}
			if(l != i) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		ladder = new int[N+1][H+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());

			ladder[a][b] = 1;
			ladder[a+1][b] = -1;
		}
		
		boolean impossible = false;
		int cnt = 0;
		
		for(int i = 1; i < N; i++) {
			int oddCnt = 0;
			for(int j = 1; j <= H; j++) {
				if(ladder[i][j] == 1) {
					oddCnt++;
				}
			}
			if(oddCnt % 2 == 1) {
				cnt++;
			}
			if(cnt > 3) {
				impossible = true; 
				break;
			}
		}
		
		if(!impossible) {
			for(int i = 0; i <= 3; i++) {
			 dfs(0, i);
			}
		}
		
		System.out.println(ans);
	}
}