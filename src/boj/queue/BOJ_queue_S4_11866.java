package boj.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_queue_S4_11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, K;
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> ans = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		while(!q.isEmpty()) {
			for(int i = 0; i < K; i++) {
				if(i == K - 1) {
					ans.offer(q.poll());
				} else {
					q.offer(q.poll());
				}
			}
		}
		bw.write("<");
		for(int i = 0; i < N; i++) {
			if(i != N - 1) {
				bw.write(ans.poll() + ", ");
			} else {
				bw.write(ans.poll() + "");
			}
		}
		bw.write(">\n");
		bw.flush();
		bw.close();
	}
}