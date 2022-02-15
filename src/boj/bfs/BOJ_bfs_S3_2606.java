package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_bfs_S3_2606 {

	static int N, M;
	static boolean[][] Network;
	static boolean[] isVisited;
	static int ans = 0;
	static Queue<Integer> q = new ArrayDeque<>();
	
	public static void bfs() {
		q.offer(1);
		isVisited[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i = 1; i <= N; i++) {
				if(Network[cur][i] == true && !isVisited[i]) {
					isVisited[i] = true;
					q.offer(i);
					ans++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		Network = new boolean[N+1][N+1];
		isVisited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			Network[node1][node2] = true;
			Network[node2][node1] = true;
		}
		
		bfs();
		
		if(N == 1) ans++;
		System.out.println(ans);
	}

}