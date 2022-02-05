package boj.deque;

import java.io.*;
import java.util.*;
public class BOJ_deque_S4_10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> d = new ArrayDeque<>();
		
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push_front":
				d.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				d.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(!d.isEmpty()) {
					sb.append(d.pollFirst() + "\n");
				}else {
					sb.append(-1 + "\n");
				}
				break;
			case "pop_back":
				if(!d.isEmpty()) {
					sb.append(d.pollLast() + "\n");
				}else {
					sb.append(-1 + "\n");
				}
				break;
			case "size":
				sb.append(d.size() + "\n");
				break;
			case "empty":
				if(d.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
				break;
			case "front":
				if(!d.isEmpty()) {
					sb.append(d.peekFirst() + "\n");
				}else {
					sb.append(-1 + "\n");
				}
				break;
			case "back":
				if(!d.isEmpty()) {
					sb.append(d.peekLast() + "\n");
				}else {
					sb.append(-1 + "\n");
				}
				break;
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}