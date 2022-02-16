package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_bfs_S1_1697 {

	static int N, K;
	static boolean[] isVisited;
	static Queue<Integer> q = new ArrayDeque<>();
	static int cnt = 0;
	
	public static void find(int pos) {
		q.offer(pos);
		isVisited[pos] = true;
		
		while(!q.isEmpty()) {
			int level = q.size();
			for(int i = 0; i < level; i++) {
				int cur = q.poll();
				if(cur == K) 
					return;
				if(cur + 1 < 2 * K && !isVisited[cur + 1]) {
					isVisited[cur + 1] = true;
					q.offer(cur + 1);
				}
				if(cur > 0 && !isVisited[cur - 1]) {
					isVisited[cur - 1] = true;
					q.offer(cur - 1);
				}
				if(cur * 2 < 2 * K && !isVisited[cur * 2]) {
					isVisited[cur * 2] = true;
					q.offer(cur * 2);
				}
			}
			cnt++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		isVisited = new boolean[200001];
		
		find(N);
		
		System.out.println(cnt);
	}

}
