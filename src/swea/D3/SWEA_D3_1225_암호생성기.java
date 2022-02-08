package swea.D3;

import java.io.*;
import java.util.*;

public class SWEA_D3_1225_암호생성기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str;
		
		while((str = br.readLine()) != null) {
			int T = Integer.parseInt(str);
			Queue<Integer> q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
	outer : while(true) {
				for(int i = 1 ; i <= 5; i++) {
					int temp = q.poll();
					if(temp - i <= 0) {
						q.offer(0);
						break outer;
					}
					q.offer(temp - i);
				}
			}
			sb.append("#" + T + " ");
			int size = q.size();
			for(int i = 0; i < size; i++) {
				sb.append(q.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}