package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_simul_S5_2628 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int cut = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> rCut = new ArrayList<>();
		ArrayList<Integer> cCut = new ArrayList<>();
		
		for(int i = 0; i < cut; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int where = Integer.parseInt(st.nextToken());
			
			if(dir == 0) {
				rCut.add(where);
			} else {
				cCut.add(where);
			}
		}
		
		rCut.add(0);
		cCut.add(0);
		
		Collections.sort(rCut, Collections.reverseOrder());
		Collections.sort(cCut, Collections.reverseOrder());
		
		int rMax = 1;
		int cMax = 1;
		
		if (rCut.size() == 0) {
			rMax = R;
		}
		if(cCut.size() == 0) {
			cMax = C;
		}
		
		for(int i = 0; i < rCut.size(); i++) {
			if(R - rCut.get(i) > rMax) rMax = R - rCut.get(i);
			R = rCut.get(i);
		}
		for(int i = 0; i < cCut.size(); i++) {
			if(C - cCut.get(i) > cMax) cMax = C - cCut.get(i);
			C = cCut.get(i);
		}
		
		System.out.println(rMax * cMax);
	}
}