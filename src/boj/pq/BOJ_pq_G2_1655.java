package boj.pq;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_pq_G2_1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minQ = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (maxQ.size() <= minQ.size()) {
				maxQ.offer(num);
			} else {
				minQ.offer(num);
			}

			if ((!maxQ.isEmpty() && !minQ.isEmpty()) && maxQ.peek() > minQ.peek()) {
				int temp1 = maxQ.poll();
				int temp2 = minQ.poll();
				maxQ.offer(temp2);
				minQ.offer(temp1);
			}

			sb.append(maxQ.peek() + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}