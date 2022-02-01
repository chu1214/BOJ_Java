package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_B3_1085 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int minx = Integer.MAX_VALUE;
		int miny = Integer.MAX_VALUE;
		
		minx = x > w - x ? w - x : x;
		miny = y > h - y ? h - y : y;
		
		int ans = minx > miny ? miny : minx;
		
		System.out.println(ans);
	}
}