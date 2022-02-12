package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_S1_2527 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			int ax = Math.max(x1, x2);
			int ay = Math.max(y1, y2);
			int bx = Math.min(p1, p2);
			int by = Math.min(q1, q2);
			
			int x = bx - ax;
			int y = by - ay;
			
			if (x == 0 && y == 0) {
				System.out.println("c");
			} else if (x > 0 && y > 0) {
				System.out.println("a");
			} else if (x < 0 || y < 0) {
				System.out.println("d");
			} else {
				System.out.println("b");
			}
		}	
	}
}