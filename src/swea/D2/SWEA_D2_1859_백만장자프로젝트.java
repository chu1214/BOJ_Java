package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D2_1859_백만장자프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			long[] cost = new long[N];
			long ans = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}			
			
			long max = 0;
			for(int i = N - 1; i >= 0; i--) {
				if(cost[i] >= max) {
					max = cost[i];
					}
				else {
					ans += max - cost[i];
				}
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}