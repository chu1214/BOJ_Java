package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_dp_G3_2342 {
	
	static int[][][] sequence = new int[5][5][100000];
	static ArrayList<Integer> steps = new ArrayList<>();
	static final int INF = 98765432;

	public static int revolution(int l, int r, int cnt) {
		if(cnt == steps.size()) return 0;
		
		if(sequence[l][r][cnt] != 0) return sequence[l][r][cnt];
		
		return sequence[l][r][cnt] = Math.min(revolution(steps.get(cnt), r, cnt+1) + dance(l, steps.get(cnt)), revolution(l, steps.get(cnt), cnt+1) + dance(r, steps.get(cnt)));
	}

	public static int dance(int cur, int next) {
		if (cur == next)
			return 1;

		switch (cur) {
		case 0:
			return 2;
		case 1:
			return next == 3 ? 4 : 3;
		case 2:
			return next == 4 ? 4 : 3;
		case 3:
			return next == 1 ? 4 : 3;
		case 4:
			return next == 2 ? 4 : 3;
		default:
			return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int step = 0;

		while ((step = Integer.parseInt(st.nextToken())) != 0) {
			steps.add(step);
		}

		System.out.println(revolution(0,0,0));
	}
}