package swea.D3;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_D3_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] deck1 = new String[N / 2 + N % 2];
			String[] deck2 = new String[N / 2];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N/2 + N%2; i++) {
				deck1[i] = st.nextToken();
			}
			for(int i = 0; i < N/2; i++) {
				deck2[i] = st.nextToken();
			}
			
			sb.append("#" + t + " ");
			
			for(int i = 0; i < N/2; i++) {
				sb.append(deck1[i] + " " + deck2[i] + " ");
			}
			if(N % 2 == 1) {
				sb.append(deck1[N/2] + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}