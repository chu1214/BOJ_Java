package boj.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_search_S4_1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean isIn = false;
			int start = 0;
			int end = N - 1;
			
			if(num > list.get(end) || num < list.get(start)) {
				bw.write(0 + "\n");
				continue;
			}
			
			while(start <= end) {
				int mid = (start + end) / 2;
				if(num == list.get(mid)) {
					isIn = true;
					break;
				} else if(num > list.get(mid)) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			if(isIn) bw.write(1 + "\n");
			else bw.write(0 + "\n");
		}
		bw.flush();
		bw.close();
	}
}