package boj.simul;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_simul_S4_10158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int T = Integer.parseInt(br.readLine());
		
		P = P + T;
		Q = Q + T;
		
		P = P % (W * 2);
		Q = Q % (H * 2);
		
		if(P > W) P = (2 * W) - P;
		if(Q > H) Q = (2 * H) - Q;
		
		System.out.println(P + " " + Q);
	}
}