package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_B1_2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A, B, V;
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		int ans;
		
		if(((double)V - A) % (B - A) == 0) {
			ans = (V - A) / (A - B) + 1;
		} else {
			ans = (V - A) / (A - B) + 2;
		}
		
		System.out.println(ans);
	}

}
