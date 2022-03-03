package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_recursive_S1_1629 {

	static int A, B, C;
	
	public static long pow(long A, long B) {
		if(B == 1) return A % C;
		
		long sep = pow(A, B / 2);
		
		if(B % 2 == 1) return (sep * sep % C) * A % C;
		return sep * sep % C;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(pow(A, B));
	}
}