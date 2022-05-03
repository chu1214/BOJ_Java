package boj.ts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_ts_G1_3665 {

	static class Team implements Comparable<Team> {
		int no;
		int rank;
		int dif;

		public Team(int no, int rank) {
			super();
			this.no = no;
			this.rank = rank;
			this.dif = 0;
		}

		@Override
		public int compareTo(Team o) {
			return Integer.compare(this.rank, o.rank);
		}
	}

	static int T, N, M;
	static Team[] teams;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			teams = new Team[N + 1];
			boolean possible = true;

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int no = Integer.parseInt(st.nextToken());
				teams[no] = new Team(no, i);
			}

			M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (teams[a].rank < teams[b].rank) {
					teams[a].dif++;
					teams[b].dif--;
				} else {
					teams[a].dif--;
					teams[b].dif++;
				}
			}

			for (int i = 1; i <= N; i++) {
				teams[i].rank += teams[i].dif;
			}

			Arrays.sort(teams, 1, N + 1);

			if (teams[1].rank != 1)
				possible = false;
			else {
				sb.append(teams[1].no + " ");
				for (int i = 2; i <= N; i++) {
					if (teams[i].rank - teams[i - 1].rank != 1) {
						possible = false;
						break;
					}
					sb.append(teams[i].no + " ");
				}
			}

			if (!possible)
				System.out.println("IMPOSSIBLE");
			else {
				sb.setLength(sb.length() - 1);
				System.out.println(sb.toString());
			}
		}
	}
}