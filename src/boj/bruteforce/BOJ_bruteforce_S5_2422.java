package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_bruteforce_S5_2422 {

	static int N, M, ans = 0;
	static ArrayList<Integer>[] NO;
	static int[] choice;

	public static void combination(int cnt, int start) {
		if (cnt == 3) {
			boolean can = true;
			for (int i = 0; i < 3; i++) {
				for (int j = i + 1; j < 3; j++) {
					for (int k = 0; k < NO[choice[i]].size(); k++) {
						if (NO[choice[i]].get(k) == choice[j]) {
							can = false;
							return;
						}
					}
				}
			}
			ans++;
			return;
		}

		for (int i = start; i <= N; i++) {
			choice[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		NO = new ArrayList[N + 1];
		choice = new int[3];

		for (int i = 1; i <= N; i++) {
			NO[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			NO[a].add(b);
			NO[b].add(a);
		}

		combination(0, 1);

		System.out.println(ans);
	}
}