package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dp_G4_2096 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] max = new int[3];
		int[] min = new int[3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				max[0] = min[0] = n1;
				max[1] = min[1] = n2;
				max[2] = min[2] = n3;
			}
			else {
				int maxtemp0 = max[0], maxtemp2 = max[2];
				max[0] = Math.max(max[0], max[1]) + n1;
				max[2] = Math.max(max[1], max[2]) + n3;
				max[1] = Math.max(max[1], Math.max(maxtemp0, maxtemp2)) + n2;
				
				int mintemp0 = min[0], mintemp2 = min[2];
				min[0] = Math.min(min[0], min[1]) + n1;
				min[2] = Math.min(min[1], min[2]) + n3;
				min[1] = Math.min(min[1], Math.min(mintemp0, mintemp2)) + n2;
			}	
		}
		
		System.out.println(Math.max(Math.max(max[0], max[1]), max[2]) + " " + Math.min(Math.min(min[0], min[1]), min[2]));
	}
}