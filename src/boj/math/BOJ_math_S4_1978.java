package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_math_S4_1978 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(max < num) max = num;
			list.add(num);
		}
		
		List<Boolean> findPrime = new ArrayList<>(max + 1);
		
		findPrime.add(0, false);
		findPrime.add(1, false);
		for(int i = 2; i <= max; i++) {
			findPrime.add(true);
		}
		
		for(int i = 2; i <= max; i++) {
			if(findPrime.get(i)) {
				for(int j = i * i; j <= max; j += i) {
					findPrime.set(j, false);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(findPrime.get(list.get(i)) == true) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}