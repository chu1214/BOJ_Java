package boj.stack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BOJ_stack_S3_1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		int[] input = new int[n];
		int cnt = 1;
		List<Integer> used = new ArrayList<>();
		List<Character> history = new ArrayList<>(); 
		
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < n; i++) {
			while(input[i] >= cnt) {
				s.push(cnt);
				history.add('+');
				cnt++;
			}
			
			if(s.peek() == input[i]) {
				s.pop();
				history.add('-');
			}else {
				bw.write("NO\n");
				bw.flush();
				bw.close();
				return;
			}
		}
		
		for(Character a : history) {
			bw.write(a + "\n");
		}
		bw.flush();
		bw.close();
	}
} 