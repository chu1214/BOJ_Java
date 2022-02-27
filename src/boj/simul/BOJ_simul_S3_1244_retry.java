package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_S3_1244_retry {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] sw = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}

		int C = Integer.parseInt(br.readLine());
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());

			switch (gender) {
			case 1:
				for (int j = 1; j <= N; j++) {
					if (j % index == 0) {
						if (sw[j] == 0)
							sw[j] = 1;
						else
							sw[j] = 0;
					} 
				}
				break;
			case 2:
				if(sw[index] == 0)
					sw[index] = 1;
				else sw[index] = 0;
				
				int left = index;
				int right = index;
				while(true) {
					left--;
					right++;
					if(left < 1 || right > N || sw[left] != sw[right]) break;
					
					if(sw[left] == sw[right]) {
						sw[left] = sw[left] == 1 ? 0 : 1;
						sw[right] = sw[right] == 1 ? 0 : 1;
					}
				}
				break;
			}
		}
		for(int i = 1; i <= N; i++) {
			sb.append(sw[i] + " ");
			if(i % 20 == 0) {
				sb.setLength(sb.length() - 1);
				sb.append("\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}