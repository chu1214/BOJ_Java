package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_greedy_S1_16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int cnt = 1;	
		boolean can = false;
		
		while(B != 0) {
			if(B % 2 == 1) {
				if(B % 10 != 1) break;
				B /= 10;
			} else {
				B /= 2;
			}
			cnt++;
			if(B == A) {
				System.out.println(cnt);
				can = true;
				break;
			}
		}
		if(!can) System.out.println(-1);
	}
}