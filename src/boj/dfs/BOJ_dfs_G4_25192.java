package boj.dfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_dfs_G4_25192 {

	static int N, M, S;
	static ArrayList<Integer>[] graph;
	static boolean[] fan;
	static boolean yes;

	public static boolean dfs(int node) {
		if (graph[node].size() == 0) {
			return true;
		}

		for (int i = 0; i < graph[node].size(); i++) {
			int next = graph[node].get(i);
			if (!fan[next]) {
				if (dfs(next))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
		}

		S = Integer.parseInt(br.readLine());
		fan = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			int num = Integer.parseInt(st.nextToken());
			fan[num] = true;
		}

		if (!fan[1] && dfs(1))
			yes = true;

		if (yes)
			System.out.println("yes");
		else
			System.out.println("Yes");
	}
}