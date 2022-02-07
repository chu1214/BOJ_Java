package boj.deque;

import java.io.*;
import java.util.*;

public class BOJ_deque_G5_5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String p = br.readLine();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[,]");
			Deque<Integer> dq = new ArrayDeque<>();
			boolean isReverse = false;
			boolean isError = false;

			while (st.hasMoreTokens())
				dq.add(Integer.parseInt(st.nextToken()));

			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == 'R') {
					if (isReverse)
						isReverse = false;
					else
						isReverse = true;
				} else {
					if (dq.isEmpty()) {
						sb.append("error\n");
						isError = true;
						break;
					}
					if (isReverse)
						dq.pollLast();
					else
						dq.pollFirst();
				}
			}
			if (!isError) {
				int temp = dq.size();
				sb.append("[");
				if (!isReverse) {
					for (Integer num : dq) {
						sb.append(num + ",");
					}
				} else {
					for(int i = 0; i < temp ; i++)
						sb.append(dq.pollLast() + ",");
				}
				if(temp != 0)
					sb.setLength(sb.length() - 1);
				sb.append("]\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}