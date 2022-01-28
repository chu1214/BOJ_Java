package boj.pq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_pq_S5_1417 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		int dasom = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for(int i = 0; i < N - 1; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		if(!pq.isEmpty()) {
			while(dasom <= pq.peek()) {
				pq.add(pq.poll() - 1);
				ans++;
				dasom++;
			}
			System.out.println(ans);
			return;
		}
		System.out.println(0);
	}
}