package boj.sort;

import java.io.*;
import java.util.*;

public class BOJ_sort_S5_2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
				
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			list.add(num);
		}
		
		Collections.sort(list);
		
		for(int num : list) {
			bw.write(num + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}