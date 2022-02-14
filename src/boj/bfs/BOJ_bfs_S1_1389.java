package boj.bfs;

import java.io.*;
import java.util.*;

public class BOJ_bfs_S1_1389 {

	static int N, M;
	static boolean[][] Friends;
	static boolean[] isVisited;
	static int min = Integer.MAX_VALUE;
	static Queue<int[]> q = new ArrayDeque<>();
	
	public static int bfs(int n, int cnt) {
		int sum = 0;
		q.offer(new int[]{n, cnt});
		isVisited[n] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			sum += cur[1];
			isVisited[cur[0]] = true;
			for(int i = 1; i <= N; i++) {
				if(Friends[cur[0]][i] && !isVisited[i]) {
					isVisited[i] = true;
					q.offer(new int[] {i, cur[1]+1});
				}
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
			Friends = new boolean[N+1][N+1];
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			Friends[a][b] = true;
			Friends[b][a] = true;
		}

		for(int i = 1; i <= N; i++) {
			isVisited = new boolean[N+1];
			int temp = bfs(i, 0);
			if(temp < min) {
				min = temp;
				ans = i;
			}
		}
		System.out.println(ans);
	}
}