package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_S4_10158_retry {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		// x, y 따로 생각하기
		x += t;
		y += t;
		
		x %= (W * 2);
		y %= (H * 2);
		
		if(x > W) x = W - (x - W);
		if(y > H) y = H - (y - H);
		
		System.out.println(x + " " + y);
	}
}