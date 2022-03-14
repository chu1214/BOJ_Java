package boj.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_unionfind_G3_16562 {
	static int N, M, k;
	static int[] A;
	static ArrayList<Integer>[] friends;
	static int[] parents;
	static HashSet<Integer> s = new HashSet<>();

	public static void makeParents() {
		parents = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	public static int find(int a) {
		if (parents[a] == a)
			return a;
		return find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;
		if (A[aRoot] < A[bRoot]) {
			parents[bRoot] = aRoot;
		} else {
			parents[aRoot] = bRoot;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		A = new int[N + 1];

		friends = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			friends[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			friends[v].add(w);
		}

		makeParents();

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < friends[i].size(); j++) {
				union(i, friends[i].get(j));
			}
		}

		for (int i = 1; i <= N; i++) {
			s.add(find(i));
		}

		int cost = 0;
		for (int n : s)
			cost += A[n];

		if (cost > k)
			System.out.println("Oh no");
		else
			System.out.println(cost);
	}
}