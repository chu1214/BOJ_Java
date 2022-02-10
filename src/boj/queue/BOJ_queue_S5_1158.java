package boj.queue;

import java.io.*;
import java.util.*;

public class BOJ_queue_S5_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new ArrayDeque<>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		sb.append("<");
		while(!q.isEmpty()) {
			for(int i = 0; i < K; i++) {
				int temp = q.poll();
				if(i == K - 1) {
					sb.append(temp + ", ");
					continue;
				}
				q.offer(temp);
			}
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb.toString());
	}
}