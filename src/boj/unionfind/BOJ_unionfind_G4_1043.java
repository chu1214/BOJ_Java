package boj.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_unionfind_G4_1043 {

	static int N, M;
	static int[] parents;
	static ArrayList<Integer>[] party;

	public static void makeParents() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	public static int find(int a) {
		if (a == -1 || parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int u = find(a);
		int v = find(b);

		if (u == v)
			return false;

		if (u < v)
			parents[v] = u;
		else
			parents[u] = v;

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];
		party = new ArrayList[M];

		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
		}

		makeParents();

		st = new StringTokenizer(br.readLine());

		int truth = Integer.parseInt(st.nextToken());
		for (int i = 0; i < truth; i++) {
			parents[Integer.parseInt(st.nextToken())] = -1;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int members = Integer.parseInt(st.nextToken());
			int first = 0;
			int next = 0;
			for (int j = 0; j < members; j++) {
				if (j == 0) {
					first = Integer.parseInt(st.nextToken());
					party[i].add(first);
				} else {
					next = Integer.parseInt(st.nextToken());
					party[i].add(next);
					union(first, next);
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			boolean lie = false;
			for (int j = 0; j < party[i].size(); j++) {
				if (find(party[i].get(j)) == -1) {
					lie = true;
					break;
				}
			}
			if (!lie)
				cnt++;
		}
		System.out.println(cnt);
	}
}