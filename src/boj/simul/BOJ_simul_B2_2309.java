package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class BOJ_simul_B2_2309 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] height = new int[9];
		TreeSet<Integer> ts = new TreeSet<>();
		int sum = 0;
		
		for(int i = 0; i < 9; i++) {
			int h = Integer.parseInt(br.readLine());
			height[i] = h;
			ts.add(h);
			sum += h; 
		}
		
outer : for(int i = 0; i < 8; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(sum - height[i] - height[j] == 100) {
					ts.remove(height[i]);
					ts.remove(height[j]);
					break outer;
				}
			}
		}
		
		for(Integer num : ts) {
			sb.append(num + "\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}