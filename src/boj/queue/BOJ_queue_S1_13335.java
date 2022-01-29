package boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_queue_S1_13335 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Queue<Integer> trucks = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			trucks.offer(Integer.parseInt(st.nextToken()));
		}

		int bt = 0;
		int time = 0;
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < W; i++) {
			q.offer(0);
		}

		while (!q.isEmpty()) {
			time++;
			bt -= q.poll();
			if (!trucks.isEmpty()) {
				if (trucks.peek() + bt <= L) {
					bt += trucks.peek();
					q.offer(trucks.poll());
				} else {
					q.offer(0);
				}
			}
		}
		System.out.println(time);
	}
}