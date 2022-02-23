package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_bruteforce_G5_15686 {

	static int N, M, ans = Integer.MAX_VALUE;
	static int[][] city;
	static boolean[] visited;
	static ArrayList<Pos> chicken = new ArrayList<>();
	static ArrayList<Pos> house = new ArrayList<>();
	static ArrayList<Pos> list = new ArrayList<>();
	
	public static class Pos {
		int r;
		int c;
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void removeChicken(int start, int cnt) {
		if(cnt == M) {
			int sum = 0;
			for(int i = 0; i < house.size(); i++) {
				int min = Integer.MAX_VALUE;
				for(int j = 0; j < list.size(); j++) {
					int dis = Math.abs(house.get(i).r - list.get(j).r) + Math.abs(house.get(i).c - list.get(j).c);
					min = Math.min(min, dis);
				}
				sum += min;
			}
			ans = Math.min(ans, sum);
		}
		
		for(int i = start; i < chicken.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				list.add(chicken.get(i));
				removeChicken(i + 1, cnt + 1);
				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		city = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 1) {
					house.add(new Pos(i, j));
				} else if(city[i][j] == 2) {
					chicken.add(new Pos(i, j));
				}
			}
		}
		
		visited = new boolean[chicken.size()];

		removeChicken(0, 0);

		System.out.println(ans);
	}
}