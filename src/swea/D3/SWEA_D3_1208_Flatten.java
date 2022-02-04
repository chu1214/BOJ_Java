package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_D3_1208_Flatten {

	public static class Box implements Comparable<Box>{
		int h = 0;

		public Box(int h) {
			super();
			this.h = h;
		}

		@Override
		public int compareTo(Box o) {		
			return Integer.compare(this.h, o.h);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Box> pq = new PriorityQueue<>();
		PriorityQueue<Box> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int t = 1; t <= 10; t++) {
			int dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 100; i++) {
				Box box = new Box(Integer.parseInt(st.nextToken()));
				pq.offer(box);
				pq2.offer(box);
			}
			
			while(dump--> 0) {
				Box a = pq2.poll();
				Box b = pq.poll();
				a.h--;
				b.h++;
				pq2.add(a);
				pq.add(b);
			}
			
			int ans = pq2.peek().h - pq.peek().h;
			sb.append("#" + t + " " + ans + "\n");	
			pq.clear();
			pq2.clear();
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}