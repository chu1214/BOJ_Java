package boj.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_queue_S3_1966 {
	
	static class Printer {
		int order;
		boolean target;
		
		public Printer(int order, boolean target) {
			this.order = order;
			this.target = target;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0;  t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			List<Printer> q = new LinkedList<>();
			int cnt = 0;
			boolean isOut = false;
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				if(n == M) {
					q.add(new Printer(Integer.parseInt(st.nextToken()), true));
					continue;
				}
				q.add(new Printer(Integer.parseInt(st.nextToken()), false));
			}
			
			while(!isOut) {
				boolean isBack = false;
				isOut = true;
				for(int i = 0; i < q.size(); i++) {
					if(q.get(0).order < q.get(i).order) {
						q.add(q.get(0));
						q.remove(0);
						isOut = false;
						isBack = true;
						break;
					}
				}
				if(!q.get(0).target) isOut = false;
				if(!isBack) {
					q.remove(0);
					cnt++;
				}
			}			
			bw.write(cnt + "\n");	
		}
		br.close();
		bw.flush();
		bw.close();
	}

}