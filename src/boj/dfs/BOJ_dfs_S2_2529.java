package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_dfs_S2_2529 {

	static int K;
	static long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
	static int[][] ans;
	static ArrayList<Character> list = new ArrayList<>();
	static int[] choosed;
	static boolean[] isUsed = new boolean[10];

	public static void dfs(int node, int cnt) {

		if (cnt == K + 1) {
			long sum = 0;
			for (int i = 0; i < choosed.length; i++) {
				sum *= 10;
				sum += choosed[i];
			}
			if (max < sum) {
				max = sum;
				for(int i = 0; i < choosed.length; i++) {
					ans[0][i] = choosed[i];
				}
			}
			if (min > sum) {
				min = sum;
				for(int i = 0; i < choosed.length; i++) {
					ans[1][i] = choosed[i];
				}
			}
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (isUsed[i])
				continue;
			if ((list.get(cnt - 1) == '>' && node > i) || (list.get(cnt - 1) == '<' && node < i)) {
				choosed[cnt] = i;
				isUsed[i] = true;
				dfs(i, cnt + 1);
				isUsed[i] = false;				
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		choosed = new int[K + 1];
		ans = new int[2][K + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			list.add(st.nextToken().charAt(0));
		}

		for (int i = 0; i < 10; i++) {
			choosed[0] = i;
			isUsed[i] = true;
			dfs(i, 1);
			isUsed[i] = false;
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j <= K; j++) {
				sb.append(ans[i][j]);
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}