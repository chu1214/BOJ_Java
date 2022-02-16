package boj.pq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_pq_S2_1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			int C = Integer.parseInt(br.readLine());
			if(C == 0) {
				if(!pq.isEmpty()) {
					sb.append(pq.poll() + "\n");
				} else {
					sb.append("0\n");
				}
			} else {
				pq.offer(C);
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}