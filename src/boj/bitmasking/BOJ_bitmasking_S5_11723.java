package boj.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_bitmasking_S5_11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int M = Integer.parseInt(br.readLine());
		int s = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int x = 0;
			if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken()) - 1;
			switch(command) {
			case "add":
				if((s & 1 << x) == 0)
					s |= 1 << x;
				break;
			case "remove":
				if((s | 0 << x) != 0)
					s &= ~(1 << x);
				break;
			case "check":
				if((s & 1 << x) != 0) sb.append(1 + "\n");
				else sb.append(0 + "\n");
				break;
			case "toggle":
				if((s & 1 << x) != 0) s &= ~(1 << x);
				else s |= 1 << x;
				break;
			case "all":
				for(int j = 0; j < 20; j++) {
					s |= 1 << j;
				}
				break;
			   default:
					s = 0;
				}
			}
			System.out.println(sb.toString());
		}
	}