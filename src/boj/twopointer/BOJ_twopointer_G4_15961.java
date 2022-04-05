package boj.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_twopointer_G4_15961 {

	static int N, d, k, c;
	static int[] sushi;
	static int[] eat;
	static boolean onBelt = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sushi = new int[N];
		eat = new int[d + 1];

		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int left = 0;
		int right = left + k - 1;
		int cnt = 0;
		int max = -1;

		while (right < N + k - 1) {

			if (left == 0) {
				for (int i = left; i <= right; i++) {
					eat[sushi[i % N]]++;
					if (eat[sushi[i % N]] == 1)
						cnt++;
				}
			} else {
				eat[sushi[right % N]]++;
				if (eat[sushi[right % N]] == 1)
					cnt++;
			}

			if (eat[c] == 0)
				cnt++;

			if (cnt > max) {
				max = cnt;
			}
			if (eat[c] == 0)
				cnt--;

			eat[sushi[left]]--;
			if (eat[sushi[left]] == 0)
				cnt--;
			left++;
			right++;
		}

		System.out.println(max);
	}
}