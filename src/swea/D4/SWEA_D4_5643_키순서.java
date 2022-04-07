package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_D4_5643_키순서 {

	static int T, N, M, count;
	static ArrayList<Integer>[] graph;
	static int[] cnt;
	static boolean[] visited;

	public static void dfs(int cur) {
		count++;
		for (int i = 0; i < graph[cur].size(); i++) {
			int next = graph[cur].get(i);
			if (visited[next])
				continue;
			visited[next] = true;
			cnt[next]++;
			dfs(next);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			cnt = new int[N + 1];

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

			for (int i = 1; i <= N; i++) {
				visited = new boolean[N + 1];
				count = 0;
				dfs(i);
				cnt[i] += count;
			}

			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if (cnt[i] == N)
					ans++;
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}