package boj.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_stack_S4_10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>(); 
		String str;
		String[] strs = new String[2];
		int N = Integer.parseInt(br.readLine());
		int num;
		
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			strs = str.split(" ");
			
			switch (strs[0]) {
			case "push":
				num = Integer.parseInt(strs[1]);
				stack.push(num);
				break;
			case "pop":
				if(stack.empty())
					bw.write( -1 + "\n");
				else {
					bw.write(stack.pop() + "\n");
				}
				break;
			case "size":
				bw.write(stack.size()+ "\n");
				break;
			case "empty":
				if(stack.empty()) 
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
				break;
			case "top":
				if(stack.empty())
					bw.write(-1 + "\n");
				else { 
					bw.write(stack.peek() + "\n");
				}
				break;
			default: break;
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}