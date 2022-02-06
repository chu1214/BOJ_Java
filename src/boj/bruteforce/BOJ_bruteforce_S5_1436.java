package boj.bruteforce;

import java.io.*;

public class BOJ_bruteforce_S5_1436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int num = 665;
		
		while(N > 0) {
			num++;
			if(Integer.toString(num).contains("666")) {
				N--;
			}
		}
		
		System.out.println(num);
	}
}