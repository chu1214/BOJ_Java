package boj.simul;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_simul_B3_10250 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int[] info = new int[3];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 3; i++) {
				info[i] = Integer.parseInt(st.nextToken());
			}
			if(info[2] % info[0] == 0) {
				sb.append(info[0] + "");
			}else {
				sb.append(info[2] % info[0] + "");
			}
			if(info[2] % info[0] == 0) {
				if(info[2] / info[0] < 10) {
					sb.append(0 + "");
				}
				sb.append(info[2] / info[0] + "\n");
			}else {
				if(info[2] / info[0] + 1 < 10) {
					sb.append(0 + "");
				}
				sb.append((info[2] / info[0] + 1) + "\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}