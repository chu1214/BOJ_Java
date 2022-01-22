package boj.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_str_B2_10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[26];
		Arrays.fill(nums, -1);
		
		String str = br.readLine();
		br.close();
		
		for(int i = 0; i < str.length(); i++) {
			if(nums[str.charAt(i) - 97] == -1) {
				nums[str.charAt(i) - 97] = i;
			}
		}
		
		for(int num: nums) {
			System.out.print(num + " ");
		}		
	}
}