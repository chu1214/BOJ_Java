package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_3234_준환이의양팔저울 {

	static int N;
	static int[] weight;
	static int ans;

	public static void setWeight(int left, int right, int cnt, int isVisited, int remain) {
		if(left >= right + remain) {
			int temp = 1;
			for(int i = 0; i < N - cnt; i++) {
				temp *= 2;
			}
			for(int i = 1; i <= N - cnt; i++) {
				temp *= i;
			}
			ans += temp;
			return;
		}
		
		if (cnt == N) {
			ans++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((isVisited & 1 << i) == 0) {
				setWeight(left + weight[i], right, cnt + 1, isVisited | 1 << i, remain - weight[i]);
				if (left >= right + weight[i]) {
					setWeight(left, right + weight[i], cnt + 1, isVisited | 1 << i, remain - weight[i]);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			ans = 0;
			int remain = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				remain += weight[i];
			}

			setWeight(0, 0, 0, 0, remain);
			sb.append("#" + t + " " + ans + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}