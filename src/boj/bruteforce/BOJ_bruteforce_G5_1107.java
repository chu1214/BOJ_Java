package boj.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_bruteforce_G5_1107 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];
		
		if(M != 0) { 
			st = new StringTokenizer(br.readLine());
		
			while(st.hasMoreTokens()) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		int ans = Math.abs(N - 100);
		
		for(int i = 0; i <= 1000000; i++) {
			int onlyNum = 0;
			int plusButton = 0;
			int temp = i;
			int temp2 = 0;
			while(temp != 0) {
				if(broken[temp % 10] == true) break;
				temp2++;
				temp /= 10;
			}
			if(temp == 0) {
				if(i == 0) {
					if(broken[0] != true) onlyNum = 1;
				} else {
					onlyNum = temp2;
				}
			}
			if(onlyNum > 0) {
				plusButton = Math.abs(i - N);
				ans = ans > onlyNum + plusButton ? onlyNum + plusButton : ans;
			}
		}
		System.out.println(ans);
	}
}