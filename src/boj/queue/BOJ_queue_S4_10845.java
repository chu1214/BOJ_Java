package boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_queue_S4_10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		LinkedList<Integer> q = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			switch(str) {
			case "push":
				q.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(!q.isEmpty()) {
					System.out.println(q.poll());
				} else System.out.println(-1);
				break;
			case "size":
				if(!q.isEmpty()) {
					System.out.println(q.size());
				} else System.out.println(0);
				break;
			case "empty":
				System.out.println(q.isEmpty() == true ? 1 : 0);
				break;
			case "front":
				if(!q.isEmpty()) {
					System.out.println(q.peek());
				} else System.out.println(-1);
				break;
			case "back" :
				if(!q.isEmpty()) {
					System.out.println(q.getLast());
				} else System.out.println(-1);
				break;
			default :
				break;
			}
		}
	}
}