package boj.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_sort_S5_11650 {

	static class Pair {
		int x, y;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<>();
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Pair(x, y));
		}
		
		br.close();
		
		list.sort(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.x == o2.x) {
					return Integer.compare(o1.y, o2.y); 
				} else if (o1.x > o2.x) {
					return 1;
				}
				return -1;
			}		
		});
		
		for(Pair p : list) {
			bw.write(p.x + " " + p.y + "\n");
		}
		bw.flush();
		bw.close();
	}
}