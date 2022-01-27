package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_stack_S4_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		
		int sum = 0;
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) s.push(num);
			else s.pop();
		}
		
		while(!(s.isEmpty())) {
			sum += s.peek();
			s.pop();
		}
		System.out.println(sum);
		br.close();
	}

}