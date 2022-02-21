package boj.bfs;
import java.io.*;
import java.util.*;

public class BOJ_bfs_G4_9019 {

	static int T, A, B;
	static boolean visited[];
	static int min = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();
	
	public static class Register {
		int num;
		String command;
		
		public Register(int num, String command) {
			super();
			this.num = num;
			this.command = command;
		}
	}
	
	public static void bfs(int start, int target) {
		Queue<Register> q = new ArrayDeque<>();
		boolean[] visited = new boolean[10000];
		q.offer(new Register(start, ""));
		visited[start] = true;
		
		while(!q.isEmpty()) {
			Register current = q.poll();
			
			if(current.num == target) {
				sb.append(current.command + "\n");
			}
			
			int D = (current.num * 2) % 10000;
			if(!visited[D]) {
				visited[D] = true;
				q.offer(new Register(D, current.command + "D"));
			}
		
			int S = current.num - 1;
			if(S == - 1) S = 9999;
			if(!visited[S]) {
				visited[S] = true;
				q.offer(new Register(S, current.command + "S"));
			}
		
			int L = (current.num % 1000) * 10 + current.num / 1000;
			if(!visited[L]) {
				visited[L] = true;
				q.offer(new Register(L, current.command + "L"));
			}
		
			int R = (current.num % 10) * 1000 + current.num / 10;
			if(!visited[R]) {
				visited[R] = true;
				q.offer(new Register(R, current.command + "R"));
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			bfs(a, b);
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}