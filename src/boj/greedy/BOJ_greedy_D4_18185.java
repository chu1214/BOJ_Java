package boj.greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_greedy_D4_18185 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] factory = new int[N + 2];
		int ans = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			factory[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {

			if (factory[i + 1] > factory[i + 2]) {
				int buy2 = Math.min(factory[i], factory[i + 1] - factory[i + 2]);
				ans += 5 * buy2;
				factory[i] -= buy2;
				factory[i + 1] -= buy2;

				int buy3 = Math.min(factory[i], Math.min(factory[i + 1], factory[i + 2]));
				ans += 7 * buy3;
				factory[i] -= buy3;
				factory[i + 1] -= buy3;
				factory[i + 2] -= buy3;

			} else {
				int buy3 = Math.min(factory[i], Math.min(factory[i + 1], factory[i + 2]));
				ans += 7 * buy3;
				factory[i] -= buy3;
				factory[i + 1] -= buy3;
				factory[i + 2] -= buy3;

				int buy2 = Math.min(factory[i], factory[i + 1]);
				ans += 5 * buy2;
				factory[i] -= buy2;
				factory[i + 1] -= buy2;
			}
			ans += 3 * factory[i];
		}

		System.out.println(ans);
	}
}