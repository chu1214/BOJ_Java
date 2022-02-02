package boj.queue;

import java.util.*;

public class BOJ_queue_S4_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) q.offer(i);
		
		while(true) {
			if(N == 1) break;
			q.poll();
			q.offer(q.poll());
			if(q.size() == 1) break;
		}
		
		System.out.println(q.poll());
	}
}