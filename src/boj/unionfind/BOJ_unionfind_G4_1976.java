package boj.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_unionfind_G4_1976 {

	static int N, M;
	static ArrayList<Integer>[] list;
	static int[] parents;

	public static void makeParents() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	public static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;
		if (aRoot >= bRoot)
			parents[bRoot] = aRoot;
		else
			parents[aRoot] = bRoot;
		return true;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		parents = new int[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					list[i].add(j);
				}
			}
		}

		makeParents();

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				union(i, list[i].get(j));
			}
		}

		boolean impossible = true;
		st = new StringTokenizer(br.readLine());
		int cur = Integer.parseInt(st.nextToken());
		for (int i = 1; i < M; i++) {
			int next = Integer.parseInt(st.nextToken());
			if (find(cur) != find(next))
				break;
			else if (find(cur) == find(next)) {
				if (i == M - 1) {
					impossible = false;
					break;
				}
				cur = next;
			}
		}
		if (impossible)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
}