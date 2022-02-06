package boj.simul;

import java.io.*;
import java.util.Arrays;

public class BOJ_simul_S4_2108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] many = new int[8002];
		double avg;
		int sum = 0;
		int max = 0;
		int cnt = 0;
		int temp = 0;
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			many[nums[i] + 4000]++;
			max = max > many[nums[i] + 4000] ? max : many[nums[i] + 4000];
			sum += nums[i];
		}
		
		Arrays.sort(nums);
		
		for(int i = 0; i < 8002; i++) {
			if(many[i] == max) {
				++cnt;
				if(cnt == 1 || cnt == 2) temp = i - 4000;
				if(cnt == 2) break;
			}
		}
		
		avg = Math.round((double)sum / N);
		sb.append((int)avg + "\n");
		sb.append(nums[N/2] + "\n");
		sb.append(temp + "\n");
		sb.append(nums[N-1] - nums[0] + "");
		
		System.out.println(sb.toString());
	}
}