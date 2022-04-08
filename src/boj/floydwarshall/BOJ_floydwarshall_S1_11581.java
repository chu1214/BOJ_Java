package boj.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_floydwarshall_S1_11581 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] road = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				road[i][j] = 10000000;
			}
		}

		for (int i = 1; i <= N - 1; i++) {
			int cnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				road[i][num] = 1;
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (road[i][k] == 1 && road[k][j] == 1)
						road[i][j] = 1;
				}
			}
		}

		boolean isCycle = false;
		for (int i = 1; i <= N; i++) {
			if (road[i][i] == 1 && road[1][i] == 1) {
				isCycle = true;
				break;
			}
			if (isCycle)
				break;
		}

		if (isCycle)
			System.out.println("CYCLE");
		else
			System.out.println("NO CYCLE");
	}
}