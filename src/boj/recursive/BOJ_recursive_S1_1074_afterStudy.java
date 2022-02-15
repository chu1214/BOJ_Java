package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_recursive_S1_1074_afterStudy {
	static int N, R, C;
	static int ans = 0;
	
	public static void find(int n, int r, int c) {
		int size = (int)Math.pow(2, n);
		
		if(size == 1) return;
		
		if(r < size/2 && c < size/2) {
			find(n-1, r, c);
		} else if (r < size/2 && c >= size/2) {
			find(n-1, r, c - size / 2);
			ans += size * size / 4;
		} else if (r >= size/2 && c < size/2) {
			find(n-1, r - size / 2, c);
			ans += (size * size / 4) * 2;
		} else {
			find(n-1, r - size/2, c - size/2);
			ans += (size * size / 4) * 3;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		find(N, R, C);

		System.out.println(ans);
	}

}